package ua.kosheleva.hw28_1.model;

import ua.kosheleva.hw28_1.interfaces.IAddressForNotification;


public class NotifiableProduct extends Product implements IAddressForNotification {

    protected NotifiableProduct(NotifiableProductBuilder notifiableProductBuilder) {
        super(notifiableProductBuilder);
    }

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

    public static class NotifiableProductBuilder extends Builder {
        public NotifiableProductBuilder(long id, boolean available, String title, double price, String channel) {
            super(id, available, title, price, channel);
        }

        public Product build() {
            return new NotifiableProduct(this) {
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
            };
        }
    }
}

