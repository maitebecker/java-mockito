package dio.mockito.mockito_exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEmailTeste {

	@Mock
	private PlataformaDeEnvio plataforma;
	
	@InjectMocks
	private ServicoEnvioEmail servico;
	
	@Captor
	private ArgumentCaptor<Email> capter;
	
	@Test
	void validaDadosEnviados() {
		String enderecoDeEmail = "usuario@teste.com.br";
		String mensagem = "Olá mundo";
		boolean ehFormatoHtml = false;
		
		servico.enviaEmail(enderecoDeEmail, mensagem, ehFormatoHtml);
		
		Mockito.verify(plataforma).enviaEmail(capter.capture());
		
		Email emailCapturado = capter.getValue();
		
		Assertions.assertEquals(enderecoDeEmail, emailCapturado.getEnderecoEmail());
		Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
		Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());
	}
}
