set logscale x
set logscale y
set xlabel "N"
set ylabel "ns"
set style line 1 lt rgb "green"
set style line 2 lt rgb "red"
set style line 3 lt rgb "blue"
set key left top
set format "%'.0f"

file = "results.txt"
plot file using 4:((stringcolumn(1) eq "c.m.a.b.create.SetCreateBench.createBulk")? $7:1/0) with linespoints title "arrayset" ls 1
