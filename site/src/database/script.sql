create database animix;
use animix;
create table studio(
	idStudio int primary key auto_increment,
    nomeEmpresa varchar(45),
    email varchar(45),
    senha varchar(45),
    logradouro varchar(45),
    telefone varchar(45),
    CNPJ char(45)
);

create table funcionario(
	idFuncionario int primary key auto_increment,
    cargo varchar(45),
    nome varchar(45),
    email varchar(45),
    senha varchar(45),
    fkStudio int,
    fkCargo int,
    foreign key(fkStudio) references studio(idStudio),
    foreign key(fkCargo) references funcionario(idFuncionario)
);

create table maquina (
	idComputador int primary key auto_increment,
    disco varchar(45),
    discoIdeal double(10,2),
    memoria varchar(45),
    porcentMemoriaIdeal double(10,2),
    processador varchar(45),
    processamentIdeal double(10,2),
    sistema varchar(45),
    monitoraDisco boolean,
    monitoraMemoria boolean,
    monitoraProcessador boolean,
    monitoraSistema boolean,
    temperaturaIdeal boolean,
    fkStudioMaq int,
    fkCompMaster int,
    foreign key(fkCompMaster) references maquina(idComputador),
    foreign key(fkStudioMaq) references studio(idStudio)
);

create table dados (
	idDados int primary key auto_increment,
    temperatura double(10,2),
    porcentCPU double(10,2),
    porcentDisco double(10,2),
    tempAtividade datetime,
    qtdProcessadoresAtuantes int,
    fkMaqDados int,
    foreign key(fkMaqDados) references maquina(idComputador)
);