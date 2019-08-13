package presenter;

import view.ViewTeman;

//15-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class PresenterTeman {
    private ViewTeman view;

    public PresenterTeman(ViewTeman view){
        this.view = view;
    }

    public void setListTeman(){
        view.showListTeman();
    }
}
