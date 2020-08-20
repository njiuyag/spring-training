package cc.prayol.springtraining.repository.impl;

import cc.prayol.springtraining.data.Spittle;
import cc.prayol.springtraining.repository.SpittleRepository;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hjx
 * @date 2020/8/14
 */
@Repository
public class SpittleRepositoryImpl implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(Long max, Integer count) {
        ArrayList<Spittle> spittles = Lists.newArrayListWithExpectedSize(count);
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("spittle+" + i, new Date()));
        }
        return spittles;
    }
}
