package presenter;

import view.ViewDetailTeman;

//16-5-2019, 10116333, CHANDRA SEPTIAN, IF - 8

public class PresenterDetailTeman {
    private ViewDetailTeman view;

    public PresenterDetailTeman(ViewDetailTeman view) {
        this.view = view;
    }

    public void getFriendsDetail() {
        view.showDetail();
    }

    public void makeCall() {
        view.doCall();
    }

    public void sendEmail() {
        view.sendEmail();
    }

    public void openInstagram() {
        view.openInstagram();
    }
}
