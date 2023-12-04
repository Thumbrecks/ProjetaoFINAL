package com.api.senai.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "funcionarios", 
       uniqueConstraints = {
           @UniqueConstraint(name = "email_ukey", columnNames = "email"),
           @UniqueConstraint(name = "cpf_ukey", columnNames = "cpf"),
           @UniqueConstraint(name = "telefone_ukey", columnNames = "telefone")
       })

public class Funcionario extends Pessoa{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcId ;
    private Agencia agencia;
    private String cargo;
    private Timestamp dataExclusao;
    private Boolean ativo;
    private String senha;

    public void setAllAtributos(Funcionario funcionarioAtualizado) {
    }
}


/* 
Este código define a classe  Funcionario  que representa a entidade de funcionário em um sistema. A classe estende a classe  Pessoa . 
 
A classe  Funcionario  possui as seguintes propriedades: 
 
-  funcId : O ID do funcionário, gerado automaticamente com estratégia de incremento automático. 
-  agencia : Uma instância da classe  Agencia  que representa a agência à qual o funcionário está associado. 
-  cargo : O cargo do funcionário. 
-  dataExclusao : Um objeto  Timestamp  que representa a data de exclusão do funcionário. 
-  ativo : Um valor booleano que indica se o funcionário está ativo ou não. 
-  senha : A senha do funcionário. 
-  endereco : Uma instância da classe  Endereco  que representa o endereço do funcionário. 
 
A classe também possui a anotação  @Entity  para indicar que é uma entidade persistente no banco de dados. A tabela correspondente no banco de dados é definida pela anotação  @Table . Existem também algumas restrições únicas definidas para as colunas  email ,  cpf  e  telefone . 
 
A classe  Funcionario  possui um método  setAllAtributos(Funcionario funcionarioAtualizado)  que pode ser usado para atualizar todos os atributos do funcionário com base em um objeto  Funcionario  atualizado. No entanto, o corpo do método está vazio e não implementa a lógica de atualização dos atributos.

*/
    

