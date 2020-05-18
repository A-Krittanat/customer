package com.dagitalacademy.customer.controller;

import com.dagitalacademy.customer.api.LoanServiceTest;
import com.dagitalacademy.customer.support.CustomerSupportTest;
import com.digitalacademy.customer.api.LoanApi;
import com.digitalacademy.customer.controller.LoanController;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = LoanControllerTest.class)
public class LoanControllerTest {

    @Mock
    LoanApi loanApi;

    @InjectMocks
    LoanController loanController;

    private MockMvc mvc;

    public static final String urlCustomer = "/loan/";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        loanController = new LoanController(loanApi);
        mvc = MockMvcBuilders.standaloneSetup(loanController).build();
    }

    @DisplayName("Test get loan info should return loan information")
    @Test
    void testGetLoanInfo() throws Exception {
        Long reqId = 1L;
        when(loanApi.getLoanInfo(reqId)).thenReturn(CustomerSupportTest.getNewLoanInfo());

        MvcResult mvcResult = mvc.perform(get(urlCustomer + "/" + reqId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andReturn();

        JSONObject json = new JSONObject(mvcResult.getResponse().getContentAsString());
        assertEquals("1", json.get("id").toString());
        assertEquals("OK", json.get("status"));
        assertEquals("102-100-1000", json.get("account_payable"));
        assertEquals("102-100-2000", json.get("account_receivable"));
        assertEquals(2000.0, json.get("principal_amount"));

    }

}
