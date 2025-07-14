package br.ufc.tp.vestuario.itens;


public enum ConservacaoEnum {
	RUIM(1),
	BOA(2),
	NOVA(3);
	
	private Integer code;
	
	ConservacaoEnum(Integer code){
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
}
