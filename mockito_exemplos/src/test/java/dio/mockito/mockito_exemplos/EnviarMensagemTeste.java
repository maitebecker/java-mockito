package dio.mockito.mockito_exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {
	
	@Spy
	private EnviarMensagem enviarMensagem;
	
	@Test
	void verificarComportamentoDaClasse() {
		Mockito.verifyNoInteractions(enviarMensagem);
		
		Mensagem mensagens = new Mensagem("Hello Word");
		enviarMensagem.adicionarMensagem(mensagens);
		Mockito.verify(enviarMensagem).adicionarMensagem(mensagens);;
		
		Assertions.assertFalse(enviarMensagem.getMensagens().isEmpty());
	}
}
