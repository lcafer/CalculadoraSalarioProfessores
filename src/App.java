import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Professor prof;
        try (Scanner scanner = new Scanner(System.in)) {
            prof = new Professor();
            prof.setNome(scanner);
            prof.setRegime(scanner);
            prof.setSalario(scanner);
        }
        
        System.out.printf("Nome: %s\nSalário: R$ %.2f", prof.getNome(), prof.getSalario());
    }
}


class Professor{
    /* Indices:
    * 0 - CLT
    * 1 - HORISTA
    * 2 - PJ
    */
    private boolean[] regime = {false, false, false};
    private String nome;
    private double salario;
    
    public void setRegime(Scanner scanner){
        boolean loopStart = true;
        while(loopStart){
            System.out.println("""
                               Insira seu regime de trabalho com o numero da opção que deseja:
                               [1] - CLT
                               [2] - HORISTA
                               [3] - PJ""");
            char regimeResposta = scanner.nextLine().charAt(0);
            switch (regimeResposta){
                case '1' -> {
                    this.regime[0] = true;
                    this.regime[1] = false; 
                    this.regime[2] = false;
                    loopStart = false;
                }
                case '2' -> {
                    this.regime[0] = false;
                    this.regime[1] = true; 
                    this.regime[2] = false;
                    loopStart = false;
                }
                case '3' -> {
                    this.regime[0] = false;
                    this.regime[1] = false; 
                    this.regime[2] = true;
                    loopStart = false;
                }
                default -> {
                    System.out.println("Resposta inserida incorretamente. Tente novamente.");
                }
            }
        }
    }
    
    public void setSalario(Scanner scanner){
        if(regime[0]){
            System.out.println("Insira abaixo seu salário mensal:");
            double entrada = scanner.nextDouble();
            this.salario = entrada;
        } else if(regime[1]) {
            System.out.println("Informe o número de horas trabalhadas;");
            int entrada1 = scanner.nextInt();
            System.out.println("Informe o valor da hora trabalhada");
            double entrada2 = scanner.nextDouble();
            this.salario = entrada1*entrada2;
        } else if(regime[2]){
            System.out.println("Informe o valor do contrato:");
            double entrada = scanner.nextDouble();
            this.salario = entrada;
        } else {
            System.out.println("O sistema irá fechar, o regime não foi computado");
            System.exit(0);
        }
    }
    
    public double getSalario(){
        return this.salario;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(Scanner scanner){
        System.out.println("Insira seu nome abaixo:");
        String nomeResposta = scanner.nextLine();
        this.nome = nomeResposta;
    }
}