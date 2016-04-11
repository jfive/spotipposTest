package br.com.vivareal.spotippos.util;

import com.google.common.collect.Range;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dgrodrigo on 10/04/16.
 */
public class CoordenadasUtil {

    private CoordenadasUtil() {}

    public static final Range<Integer> gerarRangeCoordenadas(Integer coordenada1, Integer coordenada2) {

        List<Integer> coordenadas = new ArrayList<Integer>(){{
            add(coordenada1);
            add(coordenada2);
            sort(Comparator.naturalOrder());
        }};

        return Range.closed(coordenadas.get(0),coordenadas.get(1));
    }


}


