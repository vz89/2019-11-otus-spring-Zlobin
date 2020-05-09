package com.project.holyvacation.actuator;

import com.project.holyvacation.repo.UserRepo;
import com.project.holyvacation.repo.VacationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "statistic")
@Component
@RequiredArgsConstructor
public class StatisticEndpoint {
    private final UserRepo userRepo;
    private final VacationRepo vacationRepo;

    @ReadOperation
    public String invoke() {
        long userCount = userRepo.count();
        long vacationCount = vacationRepo.count();
        return "{Total users count:" + userCount + ", Total vacations count:" + vacationCount + "}";
    }
}
