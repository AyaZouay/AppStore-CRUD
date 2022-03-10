package com.TalanAppStore.App.Repository;

import com.TalanAppStore.App.Model.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App,Long> {
    App findByName(String name);
}
