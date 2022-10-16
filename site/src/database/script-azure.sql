create table studio(
	idStudio int primary key IDENTITY,
    nomeEmpresa varchar(45),
    email varchar(45),
    senha varchar(45),
    logradouro varchar(45),
    telefone varchar(45),
    CNPJ varchar(45)
);

create table funcionario(
	idFuncionario int primary key identity,
    cargo varchar(45),
    nome varchar(45),
    email varchar(45),
    senha varchar(45),
    fkStudio int,
    foreign key(fkStudio) references studio(idStudio)
);

create table maquina (
	idMaquina int primary key identity,
    disco varchar(45),
    discoIdeal float,
    memoria varchar(45),
    memoriaIdeal float,
    processador varchar(45),
    processamentoIdeal float,
    sistema varchar(45),
    monitoraDisco varchar(45),
    monitoraMemoria varchar(45),
    monitoraProcessador varchar(45),
    monitoraSistema varchar(45),
    temperaturaIdeal varchar(45),
    fkStudio int,
    foreign key(fkStudio) references studio(idStudio)
);

create table dados (
	idDados int primary key identity,
    temperatura float,
    usoCPU float,
    usoDisco float,
    tempAtividade datetime,
    usoMemoria float,
    horaCaptura datetime,
    idMaquina int,
    foreign key(idMaquina) references maquina(idMaquina)
);


insert into dados(temperatura, usoCPU, usoDisco, tempAtividade, usoMemoria, horaCaptura, idMaquina) values
(55.5, 76.3, 87.9, (convert(datetime,'18-06-12 10:34:09 PM',5)), 65.7, (convert(datetime,'18-06-12 10:34:09 PM',5)), 1 )