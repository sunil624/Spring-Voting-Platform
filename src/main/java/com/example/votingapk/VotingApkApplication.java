package com.example.votingapk;

import com.example.votingapk.dto.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VotingApkApplication {

    public static void main(String[] args) {
        SpringApplication.run(VotingApkApplication.class, args);
        User user1 = new User("Sunil Shah",20);
        User user2 = new User("Sunil",20);
        System.out.println(user1 == user2);
        System.out.println(user1.equals(user2));

    }
}
