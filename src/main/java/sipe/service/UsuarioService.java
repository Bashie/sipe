package sipe.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sipe.dao.UsuarioDAO;
import sipe.model.Usuario;
import sipe.service.exception.InvalidLoginException;
import sipe.util.CryptWithMD5;

@Component
public class UsuarioService {
	@Autowired
	private UsuarioDAO usuarioDao;
	
	public Usuario findById(Integer id) {
		return usuarioDao.findById(id);
	}
	
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	public String login(String username, String password) throws InvalidLoginException {
		Usuario usuario;
		try {
			usuario = this.findByUsername(username);
		} catch (NoResultException e) {
			throw new InvalidLoginException();
		}
		if (Objects.nonNull(usuario) && usuario.getEncryptedPassword().equals(CryptWithMD5.cryptWithMD5(password))) {
			return createToken(usuario);
		}
		return null;
	}
	
	private String createToken(Usuario usuario) {
		JsonObject json = new JsonObject();
		json.addProperty("login", usuario.getPersona().getDni());
		json.addProperty("nombre", usuario.getPersona().getNombre());
		json.addProperty("dni", usuario.getDni());
		json.addProperty("userType", usuario.getType().name());
		json.addProperty("token", getJWTToken(String.valueOf(usuario.getPersona().getDni())));
		return json.toString();
	}
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}

	public String getDatos(String id) {
		Usuario usuario = this.findById(Integer.valueOf(id));
		return usuario.toDTO().toJson().toString();
	}
}
