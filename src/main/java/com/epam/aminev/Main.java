package com.epam.aminev;

import com.epam.aminev.dto.HumanDto;
import com.epam.aminev.services.Service;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Service<Human, HumanDto> service = new Service<>();

        System.out.println("Получение одной сущности из репозитория:");
        HumanDto singleHuman = service.getById(0);
        System.out.println(singleHuman);

        System.out.println("Добавление одной сущности (DTO) в репозиторий");
        service.save(singleHuman);

        List<HumanDto> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(service.getById(i));
        }

        System.out.println("Добавление списка сущностей (DTO) в репозиторий");
        service.saveAllToRepository(list);
    }
}