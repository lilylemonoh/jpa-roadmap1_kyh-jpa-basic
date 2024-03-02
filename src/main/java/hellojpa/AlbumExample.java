package hellojpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A") // DTYPE - 엔티티명이 디폴트임. 바꾸고 싶다면 이름 지정.
public class AlbumExample extends ItemExample {
    private String artist;
}
