package com.touk.parking.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.math.BigDecimal;
import java.util.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.touk.parking.model.TransactionAggregateModel;
import com.touk.parking.model.TransactionAggregateModelContainingMoneyModel;
import com.touk.parking.service.TransactionAggregateService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TransactionAggregateController.class)
public class TransactionAggregateControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TransactionAggregateService service;

	@Test
	public void transactionAggregateTest_SearchingTransactionTotalIncomeByDate() throws Exception {
		TransactionAggregateModelContainingMoneyModel testTransactionAgg = createAggregateModelForTest();
		given(service.getEarningsByDate("2010-12-12")).willReturn(testTransactionAgg);
		performTest("/transaction-aggregate/2010-12-12");
	}

	private TransactionAggregateModelContainingMoneyModel createAggregateModelForTest() {
		return new TransactionAggregateModelContainingMoneyModel (new TransactionAggregateModel("2010-12-12", new BigDecimal("100.00"), Currency.getInstance("PLN")));
	}

	private void performTest(String url) throws Exception {
		mvc.perform(get(url).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.date", equalTo("2010-12-12")))
				.andExpect(jsonPath("$.moneyModel.amount", equalTo(100.00)))
				.andExpect(jsonPath("$.moneyModel.currency", equalTo("PLN")));

	}

}
