package view;

import java.util.Date;
import model.Pedido;
import model.enums.StatusPedido;

public class Interface {

	public static void main(String[] args) {
		Pedido pedido = new Pedido(1080, new Date(), StatusPedido.PAGAMENTO_PENDENTE);
		
		System.out.println(pedido);

		StatusPedido sp1 = StatusPedido.ENTREGUE;
		StatusPedido sp2 = StatusPedido.valueOf("ENTREGUE");
		
		System.out.println(sp1);
		System.out.println(sp2);
	}

}
