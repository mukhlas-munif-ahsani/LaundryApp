package com.tiunida.laundry0.ActivityOrderDetail.Interactor;

public interface OrderDetailInteractorMvp {
    void getOrderData(String order_id);
    void updatePaid(String order_id);
    void updateDeliver(String order_id);
}
