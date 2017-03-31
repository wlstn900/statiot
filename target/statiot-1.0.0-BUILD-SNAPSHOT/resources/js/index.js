var today=new Date();
var time=today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
var data = [
  { x: time, a: 22, b: 13},
  { x: time, a: 26, b: 15},
  { x: time, a: 24, b: 16},
  { x: time, a: 27, b: 14},
  { x: time, a: 25, b: 17}
],
config = {
  parseTime: false,
  data: data,
  xkey: 'x',
  ykeys: ['a', 'b'],
  labels: ['Temperature', 'Humidity'],
  fillOpacity: 0.6,
  hideHover: 'auto',
  behaveLikeLine: true,
  resize: true,
  pointFillColors: ['white'],
  pointStrokeColors: ['white'],
  lineColors: ['red','blue']
};

/* config.element = 'area-chart';
Morris.Area(config); */
config.element = 'line-chart';
Morris.Line(config);
/* config.element = 'bar-chart';
Morris.Bar(config);
config.element = 'stacked';
config.stacked = true;
Morris.Bar(config);
Morris.Donut({
  element: 'pie-chart',
  data: [
    {label: "Friends", value: 30},
    {label: "Allies", value: 15},
    {label: "Enemies", value: 45},
    {label: "Neutral", value: 10}
  ]
}); */