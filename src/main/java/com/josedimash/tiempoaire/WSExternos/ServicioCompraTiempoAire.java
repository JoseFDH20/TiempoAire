package com.josedimash.tiempoaire.WSExternos;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.josedimash.tiempoaire.model.CompraPaqueteRequestBody;
import com.josedimash.tiempoaire.model.MensajeCompraResponse;

public class ServicioCompraTiempoAire {

    private static final Logger LOGGER = LogManager.getLogger(ServicioCompraTiempoAire.class);
    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public void close() {
        try {
            httpClient.close();
        } catch (IOException e) {
            LOGGER.info("Error: ", e);
        }
    }

    public static MensajeCompraResponse sendGet(String urlServicio, CompraPaqueteRequestBody requestBody) throws Exception {
    	HttpPost request = new HttpPost(urlServicio);

    	Gson gson = new Gson();
    	String json = gson.toJson(requestBody);
    	
    	StringEntity stEntity = new StringEntity(json);
    	stEntity.setContentType(ContentType.APPLICATION_JSON.getMimeType());
    	request.setEntity(stEntity);
    	request.setHeader("Content-type", "application/json");
    	
        MensajeCompraResponse mensajeResponse = null;
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            LOGGER.info("REQUEST: " + request);
            LOGGER.info("RESPONSE: " + response);
            if (response.getStatusLine().getStatusCode() == 200) {
                mensajeResponse = gson.fromJson(result, MensajeCompraResponse.class);
                return mensajeResponse;
            }
        }

        return mensajeResponse;
    }
	
}
