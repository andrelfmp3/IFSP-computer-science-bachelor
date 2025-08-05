function calcularBissexto() {
  const day_array = [
    'Domingo',
    'Segunda-Feira',
    'Terça-Feira',
    'Quarta-Feira',
    'Quinta-Feira',
    'Sexta-Feira',
    'Sábado'
  ];


  const date_input = new Date(document.form_name.date.value);

  const calcular_bissexto = (ano) =>
    (ano % 4 === 0 && ano % 100 !== 0) || (ano % 400 === 0)
      ? 'É bissexto'
      : 'Não é bissexto';

  document.querySelector('#tipo').innerText = calcular_bissexto(date_input.getFullYear());
  document.querySelector('#dia').innerText = day_array[date_input.getDay()];
}
