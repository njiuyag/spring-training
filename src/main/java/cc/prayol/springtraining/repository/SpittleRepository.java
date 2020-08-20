package cc.prayol.springtraining.repository;

import cc.prayol.springtraining.data.Spittle;

import java.util.List;

/**
 * @author hjx
 * @date 2020/8/14
 */
public interface SpittleRepository {
    /**
     *
     * @return
     */
    List<Spittle> findSpittles(Long max,Integer count);
}
