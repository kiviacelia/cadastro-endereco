create table endereco(
	id UUID not null primary key,
	logradouro VARCHAR (100) not null,
	numero integer not null,
	complemento varchar (20),
	bairro varchar (20) not null,
	cidade varchar(20) not null,
	estado varchar(50) not null,
	pais varchar(50) not null,
	cep varchar(10) not null,
	latitude numeric,
	longitude numeric
) ;