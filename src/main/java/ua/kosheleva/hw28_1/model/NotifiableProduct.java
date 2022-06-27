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

        public NotifiableProductBuilder setIdValue(long id) {
            notifiableProduct.setId(id);
            return this;
        }

        public NotifiableProductBuilder setAvailableValue(boolean available) {
            notifiableProduct.setAvailable(available);
            return this;
        }

        public NotifiableProductBuilder setTitleValue(String title) {
            notifiableProduct.setTitle(title);
            return this;
        }

        public NotifiableProductBuilder setPriceValue(double price) {
            notifiableProduct.setPrice(price);
            return this;
        }

        public NotifiableProductBuilder setChannelValue(String channel) {
            notifiableProduct.setChannel(channel);
            return this;
        }

        public NotifiableProduct build() {
            return notifiableProduct;
        }

    }
}

