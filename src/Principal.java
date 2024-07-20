import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o limite do cartao" );
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite a descricao da compra:");
            String descricao = leitura.next();

            System.out.println("Digite o valor da compra:");
            double valor = leitura.nextDouble();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada!\nDigite 0 para sair e 1 para continuar");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente!");
                sair = 0;
            }
        }

            System.out.println("************************\nCOMPRAS REALIZADAS");
            Collections.sort(cartao.getCompras());
            for (Compra c : cartao.getCompras()){
                System.out.println(c.getDescricao() + " - " +c.getValor());

            }
            System.out.println("\n************************\n\nSaldo do cartao: " + cartao.getSaldo());

    }
}
