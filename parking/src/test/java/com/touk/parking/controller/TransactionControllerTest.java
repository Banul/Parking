package com.touk.parking.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import static org.mockito.BDDMockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.touk.parking.model.FullDriverModel;
import com.touk.parking.model.TransactionModel;
import com.touk.parking.service.TransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TransactionService service;

	@Test
	public void transactionTest_SearchingTransactionByDate() throws Exception {
		List<TransactionModel> testTransaction = createTransactionForTest();
		given(service.getTransactionsByDate("2010-01-01")).willReturn(testTransaction);
		performTest("/transaction/2010-01-01");

	}

	private List<TransactionModel> createTransactionForTest() {
		FullDriverModel testDriver = new FullDriverModel(10, "Bożena", "Małolepsza", "2018-01-01", "2018-01-02", true,
				false, 2222, "XYZ");

		TransactionModel transaction = new TransactionModel(5, "2010-01-01", 50.5, true, testDriver);
		return Arrays.asList(transaction);
	}

	private void performTest(String url) throws Exception {
		mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", equalTo(5))).andExpect(jsonPath("$[0].date", equalTo("2010-01-01")))
				.andExpect(jsonPath("$[0].price", equalTo(50.5)))
				.andExpect(jsonPath("$[0].fullDriverModel.id", equalTo(10)))
				.andExpect(jsonPath("$[0].fullDriverModel.name", equalTo("Bożena")))
				.andExpect(jsonPath("$[0].fullDriverModel.surname", equalTo("Małolepsza")))
				.andExpect(jsonPath("$[0].fullDriverModel.meterLastTimeStart", equalTo("2018-01-01")))
				.andExpect(jsonPath("$[0].fullDriverModel.meterLastTimeStop", equalTo("2018-01-02")))
				.andExpect(jsonPath("$[0].fullDriverModel.pesel", equalTo(2222)))
				.andExpect(jsonPath("$[0].fullDriverModel.vehicleNumber", equalTo("XYZ")))
				.andExpect(jsonPath("$[0].fullDriverModel.vip", equalTo(true)))
				.andExpect(jsonPath("$[0].fullDriverModel.meterActive", equalTo(false)));

	}

}
