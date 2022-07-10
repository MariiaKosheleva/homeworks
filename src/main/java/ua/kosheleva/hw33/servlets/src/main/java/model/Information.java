package model;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Information {
    private String ipAddress;
    private String userAgent;
    private LocalTime localTime;
}
