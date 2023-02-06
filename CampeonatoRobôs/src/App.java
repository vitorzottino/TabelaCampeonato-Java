import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class App {

    public static final int EQUIPES = 4;
    public static void main(String[] args){
        
        Random R = new Random();
        Scanner input = new Scanner(System.in);
            
        String equipes[] = new String[EQUIPES];       
        int pontos[] = new int[EQUIPES];
        int resultado[] = new int[EQUIPES];
        int design[] = new int[EQUIPES];
        
        int tamanho = equipes.length;
        int i, j;


    try{
        for (i = 0; i < tamanho; i++){

          System.out.print("Informe o ID da " + (i+1) + "ª equipe: ");
          equipes[i] = input.nextLine().toUpperCase();
                 
        }
    }
        
    finally{
        input.close();
    }

  for (i = 0; i < tamanho; i++){
    for (j = i+1; j< tamanho; j++){               
      System.out.print("\n" + equipes[i] + " x " + equipes[j]);
      pontos[i] = R.nextInt(11);
      pontos[j] = R.nextInt(11);
      System.out.println("\nEquipe " + equipes[i] + ": " + pontos[i] + " // " + "Equipe " + equipes[j] + ": " + pontos[j] );

        if(pontos[i] > pontos[j]){
          resultado[i]+= 2;
          System.out.println(equipes[i] + " VENCEDOR");
        }
                    
           else{
            if(pontos[i] == pontos[j]){
               System.out.println("EMPATE");
               resultado[i] +=1;
               resultado[j] +=1;

               design[i] = R.nextInt(11);
               design[j] = R.nextInt( 11);
    
               System.out.println("\nPONTOS DE DESIGN");
               System.out.println("Equipe " + equipes[i] + ": " +design[i] +" pontos.");
               System.out.println("Equipe " + equipes[j] + ": " +design[j] +" pontos.");

              if(design[i] > design[j]){
                resultado[i] += 1;
                System.out.println("\n" + equipes[i] + " VENCEDOR!");
              }
                                        
                else{
                  resultado[j] += 1;
                  System.out.println("\n" + equipes[j] + " VENCEDOR!");
                }
                            
            }

                else{
                  resultado[j] +=2;
                  System.out.println(equipes[j] + " VENCEDOR"); 
                }
           }

                if (resultado[i] == resultado[j]){
                    design[i] = R.nextInt( 11);
                    design[j] = R.nextInt( 11);
                }
                        
    }   
   }
              

    Rank(equipes, resultado, design);   

    for (i = 0; i < tamanho; i++)
        System.out.println("\n" + (i+1) + "º lugar: " + equipes[i] + " |" + resultado[i] + " pontos" + " // Design: " + design[i]);

        System.out.print("--------------------");
        System.out.print("\nFINALISTAS");
        System.out.println("");

         for (i = 0; i < 3; i++){
            if (i < 2)
             System.out.print(equipes[i] + " x ");

            else
             System.out.print(equipes[i]);
                            
         }

            System.out.println(" ");
            System.out.print("\nPARTIDAS DA FINAL");
            
            Arrays.fill(resultado, 0);

        for (i = 0; i < 3; i++)
          for (j = i+1; j < 3; j++){
            System.out.print("\n" + equipes[i] + " x " + equipes[j]);
              pontos[i] = R.nextInt( 11);
              pontos[j] = R.nextInt( 11);
              System.out.println("\nEquipe " + equipes[i] + ": " + pontos[i] + " // " + "Equipe " + equipes[j] + ": " + pontos[j] );

                if(pontos[i] > pontos[j]){
                 resultado[i]+= 2;
                 System.out.println(equipes[i] + " VENCEDOR");
                }
                    
                else{
                  if(pontos[i] == pontos[j]){
                    System.out.println("EMPATE");
                    resultado[i] +=1;
                    resultado[j] +=1;

                    if(design[i] > design[j]){
                     resultado[i] += 1;
                     System.out.println("\n" + equipes[i] + " VENCEDOR!");
                    }
                                    
                     else{
                      resultado[j] += 1;
                      System.out.println("\n" + equipes[j] + " VENCEDOR!");
                    }
                            
                  }
                    else{
                     resultado[j] +=2;
                     System.out.println(equipes[j] + " VENCEDOR"); 
                    }

                }


                 if (resultado[i] == resultado[j]){
                  design[i] = R.nextInt(11);
                  design[j] = R.nextInt(11);
                }

          } // For (j)
                
        Rank(equipes, resultado, design);
          System.out.print("\nTABELA DOS FINALISTAS");
          System.out.println(" ");

        for (i = 0; i < 3; i++)    
          System.out.println("\n" + (i+1) + "º lugar: " + equipes[i] + " |" + resultado[i] + " pontos" + " // Design: " + design[i]);
          System.out.println("\n" + equipes[0] + " É A EQUIPE CAMPEÃ");
                 
        
    }

    public static void Rank(String equipes[], int resultado[], int design[]){

        int aux, i, j;
        int tamanho = equipes.length;
        String auxS;

         for (i = 0; i < tamanho; i++)
            for (j = 0; j < tamanho-1; j++){
                if ((resultado[j] < resultado[j+1]) || 
                   ((resultado[j] == resultado[j+1]) && (design[j + 1] > design[j]))
                ){

                    aux = resultado[j+1];
                    resultado[j+1] = resultado[j];
                    resultado[j] = aux;

                    aux = design[j];
                    design[j] = design[j+1];
                    design[j+1] = aux;

                    auxS = equipes[j];
                    equipes[j] = equipes[j + 1];
                    equipes[j + 1] = auxS;
                }         
            }
    }
}
