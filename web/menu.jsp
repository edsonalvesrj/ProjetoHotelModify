<nav class="navbar navbar-default">
            <div class="container-fluid">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand alert-dismissable active alert-success " href="home.jsp">Hoteis Arj </a>

                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li ><a href="Servicos_Ctr?action=listagemservicos">Serviços </a></li>        
                        <li><a href="Quartos_Ctr?action=listagemquartos">Quartos</a></li>
                        <li><a href="Funcionario_Ctr?action=listagemfuncionario">Funcionários</a></li> 
                        <li><a href="Tarefa_Ctr?action=listagemtarefas"> Tarefas</a></li> 
                    </ul>

                    <ul class="nav navbar-nav navbar-right">


                        <li class="dropdown">            
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastros <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li  class="navbar-collapse"><a href="Quartos_Ctr?action=cadquartos">Quartos</a></li> 
                                <li  class="navbar-collapse"><a href="Funcionario_Ctr?action=cadfuncionario">Funcionários</a></li>
                                <li  class="navbar-collapse"><a href="Servicos_Ctr?action=cadservicos">Serviços</a></li>                                
                                <li role="separator" class="divider"></li>  

                            </ul>
                        <li class="nav"> <a href="#">Ferramentas</a></li>        
                        <li class="nav"> <a href="#">Ajustes</a></li>        
                        <li class="active nav"> <a href="#">Sobre Nós</a></li>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
        </nav> 