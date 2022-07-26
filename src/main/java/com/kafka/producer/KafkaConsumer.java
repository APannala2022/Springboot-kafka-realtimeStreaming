package com.kafka.producer;

import com.kafka.constant.ApplicationConstant;
import com.kafka.dto.SpaceRequest;
import com.kafka.helper.kafkaHelper;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.annotation.KafkaListener;
import org.slf4j.Logger;

import com.cbre.host.platform.exception.HostException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;

@RestController
//@RequestMapping("/consume")
public class KafkaConsumer {

	@Autowired
	private ConcurrentKafkaListenerContainerFactory<String, SpaceRequest> factory;
	
	@Autowired
	private kafkaHelper helper;
	
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_NAME, containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
		public void receivedMessage(SpaceRequest message) throws JsonProcessingException {
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(message);
			
			System.out.printf("The record is  - \n " + jsonString);
			
			
			boolean isPatchUpdate = false;
			String authorization = "eyJ0eXAiOiJKV1QiLCJub25jZSI6IloyUTFiSnlLanlIS2swOTlCTk5mY3BRYUp5WTd1VjFCaDBmY0ZITlFEdDAiLCJhbGciOiJSUzI1NiIsIng1dCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSIsImtpZCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC8wMTU5ZTlkMC0wOWEwLTRlZGYtOTZiYS1hM2RlZWEzNjNjMjgvIiwiaWF0IjoxNjU4NDEyMDk3LCJuYmYiOjE2NTg0MTIwOTcsImV4cCI6MTY1ODQxNjcyNSwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkUyWmdZTmljL09DV2Zmdm5iTDNEOTg2WlhibW4yV1dYM0hUZVdFbmhTTW16eHBOTlFyWUEiLCJhbXIiOlsid2lhIl0sImFwcF9kaXNwbGF5bmFtZSI6Ikhvc3QgLSBQb3J0YWwiLCJhcHBpZCI6IjA2NWVmMWUzLTI0MzQtNDlkZi1iY2ViLWQyMzI5YjFkNzlkMiIsImFwcGlkYWNyIjoiMCIsImZhbWlseV9uYW1lIjoiUGFubmFsYSIsImdpdmVuX25hbWUiOiJBaXNod2FyeWEiLCJpZHR5cCI6InVzZXIiLCJpcGFkZHIiOiIyMDguNjguMjQ3LjE1MyIsIm5hbWUiOiJQYW5uYWxhLCBBaXNod2FyeWEgQCBHbG9iYWwgRFx1MDAyNlQiLCJvaWQiOiIwYjYyNDRkNC1kNTc2LTRhZTItYTE3MS00YWUzOWUwMGQ2MmIiLCJvbnByZW1fc2lkIjoiUy0xLTUtMjEtNjMwMzM3Mzk1LTI0MDIzNDkyMjQtMjY1Njk1OTU4My01NTcwNDciLCJwbGF0ZiI6IjUiLCJwdWlkIjoiMTAwMzIwMDFGOEE1NDU3OSIsInJoIjoiMC5BUndBME9sWkFhQUozMDZXdXFQZTZqWThLQU1BQUFBQUFBQUF3QUFBQUFBQUFBQWNBQTguIiwic2NwIjoiQ2FsZW5kYXJzLlJlYWQuU2hhcmVkIENhbGVuZGFycy5SZWFkV3JpdGUgQ2FsZW5kYXJzLlJlYWRXcml0ZS5TaGFyZWQgQ29udGFjdHMuUmVhZCBlbWFpbCBvcGVuaWQgUGVvcGxlLlJlYWQgcHJvZmlsZSBVc2VyLlJlYWQgVXNlci5SZWFkQmFzaWMuQWxsIiwic2lnbmluX3N0YXRlIjpbImlua25vd25udHdrIl0sInN1YiI6IkdfWDNqY0MxbjE1NDVLU1VJSEQyU01hT3FfNjFtLU9OTVdZQVEtVmdhSU0iLCJ0ZW5hbnRfcmVnaW9uX3Njb3BlIjoiTkEiLCJ0aWQiOiIwMTU5ZTlkMC0wOWEwLTRlZGYtOTZiYS1hM2RlZWEzNjNjMjgiLCJ1bmlxdWVfbmFtZSI6IkFpc2h3YXJ5YS5QYW5uYWxhQGNicmUuY29tIiwidXBuIjoiQWlzaHdhcnlhLlBhbm5hbGFAY2JyZS5jb20iLCJ1dGkiOiIwTjV3YmRoUUNrZVBGcm0tdWduQkFBIiwidmVyIjoiMS4wIiwid2lkcyI6WyJiNzlmYmY0ZC0zZWY5LTQ2ODktODE0My03NmIxOTRlODU1MDkiXSwieG1zX3N0Ijp7InN1YiI6IkF6X2dfaTZFMi1MSHpraDhJSHo4U2ZmLWpGRTJHMzh2Q3hvSEJzX2w3SWsifSwieG1zX3RjZHQiOjEzODY2NjQ0NDB9.YHJUWrPCa2gMQ69Gz1Gdc1NhPawx8vKU2O_Hj3j8LdgB6FCJcd1wXaKwdhsOKZYdFq-BJ4RIh5ityrfkxTK1T-hA37AXIjjrpuTNKW-VgqVZXiE6aMDZodM58jFSJQUjdJdJw0iYU_pBVaM-kGlz8UOqd1FMYb_S9Md6-51vi54kJDCLNC5n8iKkjhqpeA60PvRY31zDQl1BJr-s15CDSKZaxnZ1-h7cO7CGhoRRJxYIZhV8unNZ5zxnumUJX0DDQdBcgwssr95lm60GjV7jzDYYQR2eX8Ssuom4bNk9D90ycZSbQlhAhC50Sv5ruuKVLbjvlJnhLsXn8EvWlW3QSw";
		    String idToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSJ9.eyJhdWQiOiIwNjVlZjFlMy0yNDM0LTQ5ZGYtYmNlYi1kMjMyOWIxZDc5ZDIiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vMDE1OWU5ZDAtMDlhMC00ZWRmLTk2YmEtYTNkZWVhMzYzYzI4L3YyLjAiLCJpYXQiOjE2NTg0MTIwOTcsIm5iZiI6MTY1ODQxMjA5NywiZXhwIjoxNjU4NDE1OTk3LCJlbWFpbCI6IkFpc2h3YXJ5YS5QYW5uYWxhQGNicmUuY29tIiwiZmFtaWx5X25hbWUiOiJQYW5uYWxhIiwiZ2l2ZW5fbmFtZSI6IkFpc2h3YXJ5YSIsIm5hbWUiOiJQYW5uYWxhLCBBaXNod2FyeWEgQCBHbG9iYWwgRFx1MDAyNlQiLCJvaWQiOiIwYjYyNDRkNC1kNTc2LTRhZTItYTE3MS00YWUzOWUwMGQ2MmIiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJBaXNod2FyeWEuUGFubmFsYUBjYnJlLmNvbSIsInJoIjoiMC5BUndBME9sWkFhQUozMDZXdXFQZTZqWThLT1B4WGdZMEpOOUp2T3ZTTXBzZGVkSWNBQTguIiwic3ViIjoiQXpfZ19pNkUyLUxIemtoOElIejhTZmYtakZFMkczOHZDeG9IQnNfbDdJayIsInRpZCI6IjAxNTllOWQwLTA5YTAtNGVkZi05NmJhLWEzZGVlYTM2M2MyOCIsInV0aSI6IjBONXdiZGhRQ2tlUEZybS11Z25CQUEiLCJ2ZXIiOiIyLjAifQ.QUFXB0FbTD41Q7nutvaj-T-GsfRHFvH3y1ExN3-RYx0v9eJ_01cIqgMtCfMZ9V5sfk7Kh60MDJGKVKmQez-x65M-zdAXg6RzksWD6OxbCxMPcP6qUMkUU_ifcMItymL2gttjIJ8FbOAqrVpc7joJpAghVApCl1id1vPSZpzJGlaX5rFWniv9RtfR1SiFP4KmNUuvLF6CkJqDUUOlrsgjrwb75YKOKSsl0yUMp1ENwnhDGB2xkGkE2TQCwo4Ih3LVhd9I1VWvyXNoUm0dphvRYw2C3mpCWmQ3eVZRzt-wgNz9wE1vRFge8Ik_yyXg0jcQEpGkjTUogVSQYoEYmLB6pQ";
		    String provider = "azure";
			
			try {
				helper.updateSpace(message, authorization, idToken, provider, isPatchUpdate);
			} catch (HostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		     
			//System.out.print(recordCount);
			System.out.println("Returning spacesssss");
			
			
	}
/*
	//change it every 20-30 mins
	String authorization = "eyJ0eXAiOiJKV1QiLCJub25jZSI6IkM1YlhCeF96T2NxQzI1WW5TenJWUmpRVDJ1OWtmNG5BUnJvbGZCRWRZRG8iLCJhbGciOiJSUzI1NiIsIng1dCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSIsImtpZCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC8wMTU5ZTlkMC0wOWEwLTRlZGYtOTZiYS1hM2RlZWEzNjNjMjgvIiwiaWF0IjoxNjU4MjU4MDM5LCJuYmYiOjE2NTgyNTgwMzksImV4cCI6MTY1ODI2Mjk4MSwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkFTUUEyLzhUQUFBQXBCSDlMZjZPQXV4NG9vamNuckhJSThQRWlNT01XcjhhdGk0czljdkRWMzA9IiwiYW1yIjpbIndpYSJdLCJhcHBfZGlzcGxheW5hbWUiOiJIb3N0IC0gUG9ydGFsIiwiYXBwaWQiOiIwNjVlZjFlMy0yNDM0LTQ5ZGYtYmNlYi1kMjMyOWIxZDc5ZDIiLCJhcHBpZGFjciI6IjAiLCJmYW1pbHlfbmFtZSI6IlBhbm5hbGEiLCJnaXZlbl9uYW1lIjoiQWlzaHdhcnlhIiwiaWR0eXAiOiJ1c2VyIiwiaXBhZGRyIjoiMjA4LjY4LjI0Ni4yNTAiLCJuYW1lIjoiUGFubmFsYSwgQWlzaHdhcnlhIEAgR2xvYmFsIERcdTAwMjZUIiwib2lkIjoiMGI2MjQ0ZDQtZDU3Ni00YWUyLWExNzEtNGFlMzllMDBkNjJiIiwib25wcmVtX3NpZCI6IlMtMS01LTIxLTYzMDMzNzM5NS0yNDAyMzQ5MjI0LTI2NTY5NTk1ODMtNTU3MDQ3IiwicGxhdGYiOiI1IiwicHVpZCI6IjEwMDMyMDAxRjhBNTQ1NzkiLCJyaCI6IjAuQVJ3QTBPbFpBYUFKMzA2V3VxUGU2alk4S0FNQUFBQUFBQUFBd0FBQUFBQUFBQUFjQUE4LiIsInNjcCI6IkNhbGVuZGFycy5SZWFkLlNoYXJlZCBDYWxlbmRhcnMuUmVhZFdyaXRlIENhbGVuZGFycy5SZWFkV3JpdGUuU2hhcmVkIENvbnRhY3RzLlJlYWQgZW1haWwgb3BlbmlkIFBlb3BsZS5SZWFkIHByb2ZpbGUgVXNlci5SZWFkIFVzZXIuUmVhZEJhc2ljLkFsbCIsInNpZ25pbl9zdGF0ZSI6WyJpbmtub3dubnR3ayJdLCJzdWIiOiJHX1gzamNDMW4xNTQ1S1NVSUhEMlNNYU9xXzYxbS1PTk1XWUFRLVZnYUlNIiwidGVuYW50X3JlZ2lvbl9zY29wZSI6Ik5BIiwidGlkIjoiMDE1OWU5ZDAtMDlhMC00ZWRmLTk2YmEtYTNkZWVhMzYzYzI4IiwidW5pcXVlX25hbWUiOiJBaXNod2FyeWEuUGFubmFsYUBjYnJlLmNvbSIsInVwbiI6IkFpc2h3YXJ5YS5QYW5uYWxhQGNicmUuY29tIiwidXRpIjoiTXdOSkJ5ZFM5RWlOWmlLa18wcU9BQSIsInZlciI6IjEuMCIsIndpZHMiOlsiYjc5ZmJmNGQtM2VmOS00Njg5LTgxNDMtNzZiMTk0ZTg1NTA5Il0sInhtc19zdCI6eyJzdWIiOiJBel9nX2k2RTItTEh6a2g4SUh6OFNmZi1qRkUyRzM4dkN4b0hCc19sN0lrIn0sInhtc190Y2R0IjoxMzg2NjY0NDQwfQ.EqiIvG-dAX_S5_CPu12sEeh4gp-2awPSIu7OozH7Zm2J2pXXCrTlxxkxB-vfBlP90T2d_KeNKAKNQHNgG5LmV1Zsns9gurm4VluQVy6MLma5tz2Ql7FNRty-8YcQOGdFxBAVWIZFUSQdfHu_HQMqbc85fFu_8B-EmaVxcrd8cF0ylWRVUMRNDSBxhWwnv1BDcqPuv8MaDQzIe4BZceOQZDK-ZUHjEeZYuvQWxGHHxvu2lJTPU1PZaLtA__0ib8aolCiF6WU84IM7VQ0i4u1GnQ_k0eXfOQZqcaJ9X2Vp8eb-vHuBUfyt_lK5sdKjz8IvZPbhUXSdHhQ-S5V18sNf0A";
    String idToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IjJaUXBKM1VwYmpBWVhZR2FYRUpsOGxWMFRPSSJ9.eyJhdWQiOiIwNjVlZjFlMy0yNDM0LTQ5ZGYtYmNlYi1kMjMyOWIxZDc5ZDIiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vMDE1OWU5ZDAtMDlhMC00ZWRmLTk2YmEtYTNkZWVhMzYzYzI4L3YyLjAiLCJpYXQiOjE2NTgyNTgwMzksIm5iZiI6MTY1ODI1ODAzOSwiZXhwIjoxNjU4MjYxOTM5LCJlbWFpbCI6IkFpc2h3YXJ5YS5QYW5uYWxhQGNicmUuY29tIiwiZmFtaWx5X25hbWUiOiJQYW5uYWxhIiwiZ2l2ZW5fbmFtZSI6IkFpc2h3YXJ5YSIsIm5hbWUiOiJQYW5uYWxhLCBBaXNod2FyeWEgQCBHbG9iYWwgRFx1MDAyNlQiLCJvaWQiOiIwYjYyNDRkNC1kNTc2LTRhZTItYTE3MS00YWUzOWUwMGQ2MmIiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJBaXNod2FyeWEuUGFubmFsYUBjYnJlLmNvbSIsInJoIjoiMC5BUndBME9sWkFhQUozMDZXdXFQZTZqWThLT1B4WGdZMEpOOUp2T3ZTTXBzZGVkSWNBQTguIiwic3ViIjoiQXpfZ19pNkUyLUxIemtoOElIejhTZmYtakZFMkczOHZDeG9IQnNfbDdJayIsInRpZCI6IjAxNTllOWQwLTA5YTAtNGVkZi05NmJhLWEzZGVlYTM2M2MyOCIsInV0aSI6Ik13TkpCeWRTOUVpTlppS2tfMHFPQUEiLCJ2ZXIiOiIyLjAifQ.TGI3tV1Rmzoe9kuY59J-998EzGQfZYb511kspLRC-6YYu_jIQAdkI5NvO2adtSI6DCeFlwW-VODuE9FOIfojzb31PfGo0WGqJBIHq-W49B0Ooc2Mwan6vU-9I-9AcCJ_2U4_OgZTCfT6B18fGk8n-0t9GQWiIzZVuZwoZO3gUah4U3iQ-Ojw1Ibgl-WZ9SDK4C-BdsV96mFnfEs6WnhB786h6ZlIpnC4ivva8ERfl6WCnMC-qNnw6Q7n4cZ_OyffdkQdqWwclFcqEAVEkhMzhtHkWcQXysCfBgOhxZpFrbIjCXjs58XQgPiNLW3wccKBus07baZzSzV29zOnnrX9Mg";
    String provider = "azure";


	//@GetMapping("/message")
	public @Valid SpaceRequest receiveMessage() {
		@Valid SpaceRequest body = null ;
		
		boolean isPatchUpdate = false;
		
		
		ConsumerFactory<String, SpaceRequest> consumerFactory = (ConsumerFactory<String, SpaceRequest>) factory.getConsumerFactory();
		Consumer<String, SpaceRequest> consumer = consumerFactory.createConsumer();
		try {
			consumer.subscribe(Arrays.asList(ApplicationConstant.TOPIC_NAME));
			ConsumerRecords<String, SpaceRequest> consumerRecords = consumer.poll(10000);
		
//			while (iterator.hasNext()) {
//				SpaceRequest val = iterator.next().value();
//				//if(val != null) {
//					count++;
//					System.out.println(val);
//					//manageSpaceService.updateSpace(val, authorization, idToken, provider, isPatchUpdate);
//					//}
//			}
			
			for (ConsumerRecord<String, SpaceRequest> record : consumerRecords) 
	        {
				 System.out.printf("Inside foreach loop");
				 System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
				 body = record.value();
				 helper.updateSpace(body, authorization, idToken, provider, isPatchUpdate);

	        }	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.print(recordCount);
		System.out.println("Returning spacesssss");
		return  body;

	}*/
	}
