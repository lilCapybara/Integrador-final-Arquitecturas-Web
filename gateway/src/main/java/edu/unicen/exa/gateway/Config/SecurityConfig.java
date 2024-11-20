package edu.unicen.exa.gateway.Config;

import edu.unicen.exa.gateway.Security.AuthorityConstant;
import edu.unicen.exa.gateway.Security.jwt.JwtFilter;
import edu.unicen.exa.gateway.Security.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final TokenProvider tokenProvider;

    public SecurityConfig( TokenProvider tokenProvider ) {
        this.tokenProvider = tokenProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain( final HttpSecurity http ) throws Exception {
        http
                .csrf( AbstractHttpConfigurer::disable );
        http
                .sessionManagement( s -> s.sessionCreationPolicy( SessionCreationPolicy.STATELESS ) );  //Al ser un proyecto REST, no guardamos estados de sesion en la base de datos
        http
                .securityMatcher("api/**" )    //Todas las URL que empiezan de esta forma van a requerir autenticacion, salvo que tengan permitAll
                .authorizeHttpRequests( authz -> authz

                        .requestMatchers(HttpMethod.POST, "/api/authenticate").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
                        .requestMatchers( "api/microservicioUsuario/usuarios/encontrarPorId/**").hasAuthority( AuthorityConstant._GESTOR )
                        .requestMatchers( "api/microservicioUsuario/usuarios/quitarUsuario/**").hasAuthority( AuthorityConstant._GESTOR )
                        .requestMatchers( "api/microservicioUsuario/usuarios/modificarUsuario/**").hasAuthority( AuthorityConstant._GESTOR )
                        .requestMatchers( "api/microservicioUsuario/usuarios/cambiarEstadoUsuario/**").hasAuthority( AuthorityConstant._GESTOR )
                        .requestMatchers( "api/microservicioUsuario/usuarios/monopatinesCercanos/").hasAuthority( AuthorityConstant._USUARIO )

                        .requestMatchers( "api/microservicioMonopatin/monopatinesCercanos/**").hasAuthority( AuthorityConstant._USUARIO )

                        .requestMatchers( "api/microservicioViaje/**").hasAuthority( AuthorityConstant._GESTOR )

                        .requestMatchers( "api/microservicioParada/**").hasAuthority( AuthorityConstant._GESTOR )

                        .requestMatchers( "api/microservicioMonopatin/**").hasAuthority( AuthorityConstant._GESTOR )

                        .requestMatchers( "api/microservicioGestor/**").hasAuthority( AuthorityConstant._GESTOR )

                        .anyRequest().authenticated()   //Las demas URLs que no defini estan autenticadas
                )
                .httpBasic( Customizer.withDefaults() )
                .addFilterBefore( new JwtFilter( this.tokenProvider ), UsernamePasswordAuthenticationFilter.class );    //Filtro para autenticacion por nombre y contraseña
        return http.build();
    }

}