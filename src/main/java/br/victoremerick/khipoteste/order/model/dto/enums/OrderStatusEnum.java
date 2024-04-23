package br.victoremerick.khipoteste.order.model.dto.enums;

public enum OrderStatusEnum {

    PENDING("PEDIDO_PENDENTE"),
    PAYMENT("PAGAMENTO_CONFIRMADO"),
    FINISHED("PEDIDO_FINALIZADO"),
    CONFIRMED("PEDIDO_CONFIRMADO");

    String type;

    OrderStatusEnum(String type) {
        this.type = type;
    }

    public String getStatus() {
        return type;
    }
}
