package com.runner.app.runners.run;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface RunDataRepository extends ListCrudRepository<Run, Integer> {

//    public void updateBy();
}
