package ua.edu.nuos.spring1.services;

import org.springframework.stereotype.Component;
import ua.edu.nuos.spring1.model.Point;

import java.util.ArrayList;
import java.util.List;

@Component
public class TabulationService {
    public List<Point> tabulate(double start, double finish, double step) {

        List<Point> points = new ArrayList<>();

        int n = (int)Math.round((finish - start) / step + 1);
        for (int i = 0; i < n; i++) {
            double x = start + i * step;
            double y = Math.sin(x);
            points.add(new Point(x, y));
        }

        return points;
    }
}
