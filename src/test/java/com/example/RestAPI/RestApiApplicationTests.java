package com.example.RestAPI;

import com.example.RestAPI.controller.UserController;
import com.example.RestAPI.model.UserEntity;
import com.example.RestAPI.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class RestApiApplicationTests {

	@Mock
	private UserService userService;
	@InjectMocks
	private UserController userController;

	@Test
	void testeObterTodos() {
		//Simular dados de usuario
		List<UserEntity> userList = Arrays.asList(
			new UserEntity("1", "User1", "user1@exalple.com"),
			new UserEntity("2", "User2", "user2@exalple.com")
		);

		//Simular comportamento do serviço
		when(userService.obterTodos()).thenReturn(userList);

		//Chamar o metodo do controlador
		List<UserEntity> result = userController.obterTodos();

		//Verificar se o resultado é o esperado
		assertEquals(userList, result);
	}

	@Test
	void testObterPorId() {
		//Simular dados de usuario
		UserEntity user = new UserEntity("1", "User1", "user1@exalple.com");

		//Simular comportamento do serviço
		when(userService.obterPorId("1")).thenReturn(user);

		//Chamar o metodo do controlador
		UserEntity result = userController.obtePorId("1");

		//Verificar se o resultado é o esperado
		assertEquals(user, result);
	}

	@Test
	void testInserir() {
		//Simular dados de usuario
		UserEntity newUser = new UserEntity("1", "User1", "user1@exalple.com");

		//Simular comportamento do serviço
		when(userService.inserir(newUser)).thenReturn(newUser);

		//Chamar o metodo do controlador
		UserEntity result = userController.inserir(newUser);

		//Verificar se o resultado é o esperado
		assertEquals(newUser, result);
	}

	@Test
	void testAtualizar() {
		//Simular dados de usuario
		UserEntity updateUser = new UserEntity("1", "User1", "user1@exalple.com");

		//Simular comportamento do serviço
		when(userService.atualizar("1",updateUser)).thenReturn(updateUser);

		//Chamar o metodo do controlador
		UserEntity result = userController.atualizar("1",updateUser);

		//Verificar se o resultado é o esperado
		assertEquals(updateUser, result);
	}

	@Test
	void testExcluir() {
		//Simular comportamento do serviço
		UserEntity updateUser = new UserEntity("1", "User1", "user1@exalple.com");

		//Chamar o metodo do controlador
		userController.excluir("1");

		//Verificar se o metodo do serviço foi chamado
		verify(userService, times(1)).excluir("1");
	}

	@Test
	void contextLoads() {
	}

}
