package Recursion;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class Parkettierung {

    private Parkettierung()
    {}

    public static BigInteger anzahlParkettierungen(int m, int n)
    {
        if (m < 0 || n < 0)
        {
            return BigInteger.ZERO;
        }
        if (m == 0 || n == 0)
        {
            return BigInteger.ONE;
        }
        if ((m * n) % 2 == 1) //nur aus Effizienzgründen
        {
            return BigInteger.ZERO;
        }
        int[] freiePlaetze = new int[m];
        for (int i=0; i < m; i++)
        {
            freiePlaetze[i] = n;
        }
        return anzahlParkettierungen(freiePlaetze);
    }

//	/**
//	 * Simple Implementierung des Parkettierungsalgo ohne caching.
//	 * @param freiePlaetze
//	 * @return
//	 */
//	private static BigInteger anzahlParkettierungenSimple(int[] freiePlaetze)
//	{
//		int i = maxIndex(freiePlaetze);
//		int max = freiePlaetze[i];
//		if (max == 0)
//		{
//			return BigInteger.ONE;
//		}
//		BigInteger res;
//		if (max > 1)
//		{
//			// Domino vertikal einfügen
//			freiePlaetze[i] -= 2;
//			res = anzahlParkettierungen(freiePlaetze);
//			freiePlaetze[i] += 2;
//		}
//		else
//		{
//			res = BigInteger.ZERO;
//		}
//		if (i+1 < freiePlaetze.length && freiePlaetze[i+1] == max)
//		{
//			freiePlaetze[i]--;
//			freiePlaetze[i+1]--;
//			res = res.add(anzahlParkettierungen(freiePlaetze));
//			freiePlaetze[i]++;
//			freiePlaetze[i+1]++;
//		}
//		return res;
//	}

        private static final HashMap<String,BigInteger> CACHE = new HashMap<>();

        /**
         * Implementierung des Parkettierungsalgo mit caching.
         * @param freiePlaetze Array, das angibt, wie viele freie Plaetze es pro Spalte gibt.
         *    Die freien Plätzte liegen unten, die bereits überdeckten oben in der Spalte.
         * @return
         */
        private static BigInteger anzahlParkettierungen(int[] freiePlaetze)
        {
            String key = Arrays.toString(freiePlaetze);
            if (CACHE.containsKey(key))
            {
                return CACHE.get(key);
            }
            int i = maxIndex(freiePlaetze);
            int max = freiePlaetze[i];
            if (max == 0)
            {
                return BigInteger.ONE;
            }
            BigInteger res;
            if (max > 1)
            {
                // Domino vertikal einfügen
                freiePlaetze[i] -= 2;
                res = anzahlParkettierungen(freiePlaetze);
                freiePlaetze[i] += 2;
            }
            else
            {
                res = BigInteger.ZERO;
            }
            if (i+1 < freiePlaetze.length && freiePlaetze[i+1] == max)
            {
                freiePlaetze[i]--;
                freiePlaetze[i+1]--;
                res = res.add(anzahlParkettierungen(freiePlaetze));
                freiePlaetze[i]++;
                freiePlaetze[i+1]++;
            }
            CACHE.put(key, res);
            return res;
        }

        private static int maxIndex(int[] arr)
        {
            int max = arr[0];
            int index = 0;
            for (int i = 1; i < arr.length; i++)
            {
                if (arr[i] > max)
                {
                    index = i;
                    max = arr[i];
                }
            }
            return index;
        }

    }


