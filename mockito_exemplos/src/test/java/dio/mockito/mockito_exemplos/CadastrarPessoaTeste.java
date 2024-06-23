package dio.mockito.mockito_exemplos;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {
	
	@Mock
	private ApiDosCorreios apiDosCorreios;
	
	@InjectMocks
	private CadastrarPessoa cadastrarPessoa;
	
	@Test
	void validarDadosDeCadastro() {
		DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("RS", "Campo Bom", "Rua 1", "Casa", "Imigrante");
		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("93700000")).thenReturn(dadosLocalizacao);
		Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Maite", "123", LocalDate.now(), "93700000");
		
		Assertions.assertEquals("Maite", pessoa.getNome());
		Assertions.assertEquals("123", pessoa.getDocumento());
		Assertions.assertEquals(LocalDate.now(), pessoa.getNascimento());
		Assertions.assertEquals("RS", pessoa.getEndereco().getUf());
	}
	
	@Test
	void lancarExceptionQuandoChamarApiDosCorreios() {
		DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("RS", "Campo Bom", "Rua 1", "Casa", "Imigrante");
		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("93700000")).thenThrow(IllegalArgumentException.class);
		
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> cadastrarPessoa.cadastrarPessoa("Maite", "123", LocalDate.now(), "93700000"));
		
	}

}
