package com.tiunida.laundry0.ActivityOrderDetail.Interactor;

import com.tiunida.laundry0.ActivityOrderDetail.Model.OrderDetailRepository;
import com.tiunida.laundry0.ActivityOrderDetail.Model.OrderDetailReposritoryMvp;

public class OrderDetailInteractor implements OrderDetailInteractorMvp{
    private OrderDetailReposritoryMvp mOrderDetailReposritoryMvp;

    public OrderDetailInteractor(){
        mOrderDetailReposritoryMvp = new OrderDetailRepository();
    }

    @Override
    public void getOrderData(String order_id) {
        mOrderDetailReposritoryMvp.getOrdersData(order_id);
    }
}
