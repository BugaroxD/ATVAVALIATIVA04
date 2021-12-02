import java.util.Scanner;

/* 

+ Curso: Análise e Desenvolvimento de Sistemas (ADS)
+ Aluno: Jefferson Luiz Martins Clemente
+ Professor: Jackson Machado
+ Matéria: Programação Orientada a Objeto
+ Atividade Avaliativa 04

*/

public class AtividadeAvaliativa04 {

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int menu = 0;
    do {
        System.out.println("Digite a opção desejada: ");
        System.out.println("1. SELECT COM STATEMENT CLIENTE");
        System.out.println("2. INSERT COM STATEMENT CLIENTE");
        System.out.println("3. UPDATE COM STATEMENT CLIENTE");
        System.out.println("4. DELETE COM STATEMENT CLIENTE");
        System.out.println("5. SELECT COM STATEMENT CHEF");
        System.out.println("6. INSERT COM STATEMENT CHEF");
        System.out.println("7. UPDATE COM STATEMENT CHEF");
        System.out.println("8. DELETE COM STATEMENT CHEF");
        System.out.println("9. INFORMAÇÕES DO SISTEMA.");
        try{
            menu = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (menu) {
            case 1:
                try {
                    Cliente.printCliente(
                        Cliente.getClienteS(scanner)
                    );
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                try {
                    Cliente.insertClienteS(
                        Cliente.getClienteInsert(scanner)
                    );
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 3:
                try {
                    Cliente.updateClienteS(
                        Cliente.getClienteUpdate(scanner)
                    );
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 4:
                try {
                    Cliente.deleteClienteS(
                        Cliente.getCliente(scanner)
                    );
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                try {
                    Chef.printChef(
                        Chef.getChefS(scanner)
                    );
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 6:
                try {
                    Chef.insertChefS(
                        Chef.getChefInsert(scanner)
                    );
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 7:
                try {
                    Chef.updateChefS(
                        Chef.getChefUpdate(scanner)
                    );
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 8:
                try {
                    Chef.deleteChefS(
                        Chef.getChefInsert(scanner)
                    );
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 9:
            // Criando 3 Chef's
                Chef chefUm = Chef.getChef(1);
                Chef chefDois = Chef.getChef(2);
                Chef chefTres = Chef.getChef(3);

            // Criando 3 Clientes
                Cliente clienteUm = Cliente.getCliente(1);
                Cliente clienteDois = Cliente.getCliente(2);
                Cliente clienteTres = Cliente.getCliente(3);

            // Criando 3 Receitas ChefUm
                Receita receitaUmChefUm = new Receita(1, "X-Burguer", "Assar o Hamburguer, colocar o queijo em cima e montar o lanche", "03", "R$ 20,00", chefUm);
                Receita receitaDoisChefUm = new Receita(2, "X-Frango", "Assar o Frango, colocar o queijo em cima e montar o lanche", "03", "R$ 25,00", chefUm);
                Receita receitaTresChefUm = new Receita(3, "X-Bacon", "Assar o Hamburguer, colocar o queijo em cima, fritar o bacon e  montar o lanche", "04", "R$ 30,00", chefUm);

            // Criando 3 Receitas ChefDois
                Receita receitaUmChefDois = new Receita(4, "Fritas", "Cortar batatas, fritar as batatas", "02", "R$ 45,00", chefDois);
                Receita receitaDoisChefDois = new Receita(5, "Camarão a milanes", "Limpar o camarão, passar na farinha de rosca e fritar", "03", "R$ 80,00", chefDois);
                Receita receitaTresChefDois = new Receita(6, "Mistão", "Cortar os condimentos, fritar as batatas, fritar bacon, fritar calabresa, encher de cheddar na hora de montar ", "05", "R$ 65,00", chefDois);

            // Criando 3 Receitas ChefTres
                Receita receitaUmChefTres = new Receita(7, "Cebola caramelizada", "Picas cebolas e fritas com água e açucar", "Quantidade de Etapas: 03", "R$ 15,00", chefTres);
                Receita receitaDoisChefTres = new Receita(8, "CupCake", "Fazer um minibolo de chocolate com bastante recheio interno", "Quantidade de Etapas: 03", "R$ 14,00", chefTres);
                Receita receitaTresChefTres = new Receita(9, "Cerveja com mel", "Mistura cerveja com mel", "Quantidade de Etapas: 02", "R$ 18,00", chefTres);

            // Criando Padarias
                Padaria padariaUm = new Padaria(10, "Doce Pão", "05/12/2019","08:00Hr - 19:00Hr", 13, "89000-00", "Sonho", "Nº: 1985", "Das Iguanas", "Chuville");
                // Receitas Padaria 01
                padariaUm.executaReceita(receitaUmChefUm);
                padariaUm.executaReceita(receitaDoisChefUm);
                padariaUm.executaReceita(receitaTresChefUm);
                padariaUm.executaReceita(receitaUmChefDois);
                padariaUm.executaReceita(receitaDoisChefDois);

                Padaria padariaDois = new Padaria(11, "SóDelicias", "01/05/2020","08:00Hr - 19:00Hr", 14, "89111-11", "Soneca", "Nº: 1784", "Das Notches", "Chuville");
                // Receitas Padaria 02
                padariaDois.executaReceita(receitaTresChefDois);
                padariaDois.executaReceita(receitaUmChefTres);
                padariaDois.executaReceita(receitaDoisChefTres);
                padariaDois.executaReceita(receitaTresChefTres);
                padariaDois.executaReceita(receitaUmChefDois);

                Padaria padariaTres = new Padaria(12, "ArtVida", "02/1202018","08:00Hr - 19:00Hr", 15, "89222-22", "Ciranda", "Nº: 1644", "Das Artes", "Chuville");
                // Receitas Padaria 03
                padariaTres.executaReceita(receitaUmChefTres);
                padariaTres.executaReceita(receitaDoisChefDois);
                padariaTres.executaReceita(receitaDoisChefTres);
                padariaTres.executaReceita(receitaUmChefUm);
                padariaTres.executaReceita(receitaTresChefTres);

            // Criando Mercados
                Mercados mercadoUm = new Mercados(13, "Milanda", "12/02/2001", "Seg, Qua, Sex promoções de carnes", 16, "89333-33", "Das Bolhas", "2015", "Boladão", "Chuville");
                // Receitas Mercado 01
                mercadoUm.executaReceita(receitaUmChefTres);
                mercadoUm.executaReceita(receitaDoisChefDois);
                mercadoUm.executaReceita(receitaTresChefUm);

                Mercados mercadoDois = new Mercados(14, "Djanbolha", "12/02/2007", "Ter, Qui, Sab promoções de verduras", 17, "89444-44", "Das Ambuja", "1452", "Liborne", "Chuville");
                // Receitas Mercado 02
                mercadoDois.executaReceita(receitaDoisChefDois);
                mercadoDois.executaReceita(receitaDoisChefTres);
                mercadoDois.executaReceita(receitaUmChefTres);

                Mercados mercadoTres = new Mercados(15, "Lagustos", "12/02/2001", "Sex, Sab, Dom mercado inteiro 50% de desconto", 18, "89555-555", "Iscamoja", "2015", "Latest", "Chuville");
                // Receitas Mercado 03
                mercadoTres.executaReceita(receitaTresChefTres);
                mercadoTres.executaReceita(receitaUmChefDois);
                mercadoTres.executaReceita(receitaDoisChefTres);

            // Receitas Cliente 01
                clienteUm.executaReceita(receitaUmChefUm);
                clienteUm.executaReceita(receitaDoisChefTres);
                clienteUm.executaReceita(receitaDoisChefUm);

            // Receitas Cliente 02
                clienteDois.executaReceita(receitaUmChefDois);
                clienteDois.executaReceita(receitaTresChefTres);
                clienteDois.executaReceita(receitaUmChefDois);

            // Receitas Cliente 03
                clienteTres.executaReceita(receitaDoisChefTres);
                clienteTres.executaReceita(receitaUmChefTres);
                clienteTres.executaReceita(receitaDoisChefUm);    
 
            // Imprimindo informações no terminal!

            // Informações do Chef Um
                System.out.println("\n|==============Informações do Chef " + Chef.getChef(1) + "==============|");

                System.out.println("\n|Dados do chef " + Chef.getChef(1) + "|");
                System.out.println(chefUm);

                System.out.println("\n|Receitas do chef " + Chef.getChef(1) + "|");

                System.out.println("\nPrimeira Receita:");
                System.out.println(receitaUmChefUm);

                System.out.println("\nSegunda Receita:");
                System.out.println(receitaDoisChefUm);

                System.out.println("\nTerceira Receita:");
                System.out.println(receitaTresChefUm);

            // Informações do Chef Dois
                System.out.println("\n|==============Informações do Chef " + Chef.getChef(2) + "==============|");

                System.out.println("\n|Dados do chef " + Chef.getChef(2) + "|");
                System.out.println(chefDois);
     
                System.out.println("\n|Receitas do chef " + Chef.getChef(2) + "|");

                System.out.println("\nPrimeira Receita:");
                System.out.println(receitaUmChefDois);

                System.out.println("\nSegunda Receita:");
                System.out.println(receitaDoisChefDois);

                System.out.println("\nTerceira Receita:");
                System.out.println(receitaTresChefDois);


            // Informações do Chef Três
                System.out.println("\n|==============Informações do Chef " + Chef.getChef(3) + "==============|");

                System.out.println("\n|Dados do chef " + Chef.getChef(3) + "|");
                System.out.println(chefTres);
     
                System.out.println("\n|Receitas do chef " + Chef.getChef(3) + "|");

                System.out.println("\nPrimeira Receita:");
                System.out.println(receitaUmChefTres);

                System.out.println("\nSegunda Receita:");
                System.out.println(receitaDoisChefTres);

                System.out.println("\nTerceira Receita:");
                System.out.println(receitaTresChefTres);
      
            // Informações da Padaria Um - Doce Pão
                System.out.println("\n|==============Padaria Doce Pão Informações==============|");

                System.out.println("\n|Padaria Doce Pão|");
                System.out.println(padariaUm);

            // Informações da Padaria Dois - SóDelicias
                System.out.println("\n|==============Padaria SóDelicias Informações==============|");

                System.out.println("\n|Padaria SóDelicias|");
                System.out.println(padariaDois);

            // Informações da Padaria Três - ArtVida    
                System.out.println("\n|==============Padaria ArtVida Informações==============|");

                System.out.println("\n|Padaria ArtVida|");
                System.out.println(padariaTres);

            // Informações da Mercado Um - Milanda 
                System.out.println("\n|==============Padaria Milanda Informações==============|");

                System.out.println("\n|Mercado Milanda|");
                System.out.println(mercadoUm);

            // Informações da Mercado Dois - Djanbolha 
                System.out.println("\n|==============Padaria Djanbolha Informações==============|");

                System.out.println("\n|Mercado Djanbolha|");
                System.out.println(mercadoDois);

            // Informações da Mercado Três - Lagustos     
                System.out.println("\n|==============Padaria Lagustos Informações==============|");

                System.out.println("\n|Mercado Lagustos|");
                System.out.println(mercadoTres);    
  
            // Informações da Cliente Um
                System.out.println("\n|==============Cliente Jaco Informações==============|");

                System.out.println("\n|Cliente " + Cliente.getCliente(1) + "|");
                System.out.println(clienteUm);

            // Informações da Mercado Dois 
                System.out.println("\n|==============Cliente Jabo Informações==============|");

                System.out.println("\n|Cliente " + Cliente.getCliente(2) + "|");
                System.out.println(clienteDois);

            // Informações da Mercado Três    
                System.out.println("\n|==============Cliente Jabao Informações==============|");

                System.out.println("\n|Cliente " + Cliente.getCliente(3) + "|");
                System.out.println(clienteTres);      
  
            break;

            default:
            System.out.println("Operação inválida.");
            break;
            }
          } while (menu != 0);
            scanner.close();
        }
}
