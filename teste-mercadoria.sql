create database testeMercadoria;
use testeMercadoria;

create table mercadoria(
	codigo							int(10)			not null,
	tipoMerc						varchar(30)		not null,
	nome							varchar(30)		not null,		
	quantidade						int(10)			not null,
	preco							decimal(10,0)	not null,
	tipoNegocio						varchar(30)
);

select * from mercadoria;
