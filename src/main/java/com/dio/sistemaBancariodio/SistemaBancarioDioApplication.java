package com.dio.sistemaBancariodio;

import com.dio.sistemaBancariodio.domain.*;
import com.dio.sistemaBancariodio.enums.TipoCliente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
public class SistemaBancarioDioApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SistemaBancarioDioApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {



		//Criando Cidades
		State state1 = new State("Minas Gerais");
		State state2 = new State("Rio de Janeiro");
		State state3 = new State("São Paulo");

		//Criando Cidades
		City city1 = new City("Uberlandia", state1);
		City city2 = new City("Araguari", state1);
		City city3 = new City("Campinas", state3);
		City city4 = new City("Rio de Janeiro", state2);
		City city5 = new City("Sao Paulo", state3);

		//Criando Usuarios para banco de dados
		User user1 = new User("Matheus Gigliotti Kassagas", "mgigliotti@gmail.com", "000.000.000-00", TipoCliente.PESSOAFISICA, "1234");
		User user2 = new User("Sthefanie Alves", "sthealves@gmail.com", "111.111.111-11", TipoCliente.PESSOAFISICA, "1234");
		user1.getPhone().addAll(Arrays.asList("+5534996220000", "+553432329576"));
		user2.getPhone().addAll(Arrays.asList("+5534991027200", "+553432144656"));

		//Criando Endereco para usuarios
		Address addressUser1 = new Address("Rua Cesario Alvim", "1147", "apto 201", "Brasil", "38500-999", user1, city1);
		Address addressUser2 = new Address("Rua Mato Grosso", "2530", "casa", "Segismundo", "38400-111", user2, city2);

		//Associando end aos users
		user1.getAddresses().addAll(Arrays.asList(addressUser1));
		user2.getAddresses().addAll(Arrays.asList(addressUser2));


		List<Account> accountList = new ArrayList<>();

		//Criando Contas
		CheckAccount accountMatheus = new CheckAccount(user1);
		Account accountSthefanie = new SavingsAccount(user2);

		//Adicionando contas na lista
		accountList.add(accountMatheus);
		accountList.add(accountSthefanie);

		//Adicionando contas no Banco
		Bank bank = new Bank(accountList);

		//Dados Usuarios
		bank.printAcconts();

		// Conta Corrente Matheus Depositando
		accountMatheus.deposit(200);
		accountMatheus.printExtract();

		// Conta Corrente Matheus sacando
		accountMatheus.withdraw(100);
		accountMatheus.printExtract();

		// Conta Corrente Matheus sacando sem saldo
		accountMatheus.withdraw(101);
		accountMatheus.printExtract();

		// Conta Corrente Matheus tranferindo para Sthefanie
		accountMatheus.transfer(100, accountSthefanie);
		accountMatheus.printExtract();
		accountSthefanie.printExtract();

		// Conta Corrente Matheus tranferindo sem saldo para Sthefanie
		accountMatheus.transfer(100, accountSthefanie);
		accountSthefanie.printExtract();
		accountMatheus.printExtract();

		// Conta Corrente Matheus tarifa bancaria
		accountMatheus.bankFee(); // para teste é necessario mudar o valor do if no metodo para o dia atual
		accountMatheus.printExtract();


		// Conta Poupanca Sthefanie

	}
}
