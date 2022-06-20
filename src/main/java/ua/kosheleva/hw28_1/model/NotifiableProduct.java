package ua.kosheleva.hw28_1.model;

import ua.kosheleva.hw28_1.interfaces.IAddressForNotification;

public class NotifiableProduct extends Product implements IAddressForNotification {
    @Override
    public String generateAddressForNotification() {
        return "somerandommail@gmail.com";
    }

    @Override
    public String getBasicInfo() {
        return "NotifiableProduct { " +
                "channel = '" + channel + '\'' +
                ", id = " + id +
                ", available = " + available +
                ", title = " + title + '\'' +
                ", price = " + price +
                " }";
    }

    public static class NotifiableProductBuilder {
        private final NotifiableProduct notifiableProduct;

        public NotifiableProductBuilder() {
            notifiableProduct = new NotifiableProduct();
        }

        public NotifiableProductBuilder setWithId(long id) {
            notifiableProduct.setId(id);
            return this;
        }

        public NotifiableProductBuilder setWithAvailable(boolean available) {
            notifiableProduct.setAvailable(available);
            return this;
        }

        public NotifiableProductBuilder setWithTitle(String title) {
            notifiableProduct.setTitle(title);
            return this;
        }

        public NotifiableProductBuilder setWithPrice(double price) {
            notifiableProduct.setPrice(price);
            return this;
        }

        public NotifiableProductBuilder setWithChannel(String channel) {
            notifiableProduct.setChannel(channel);
            return this;
        }

        public NotifiableProduct build() {
            return notifiableProduct;
        }

    }
}

