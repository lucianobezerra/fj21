<%@attribute name="id" required="true"%>
<input id="${id}" name="${id}" />
<script>
  $("#${id}").datepicker({
    dateFormat: 'dd/mm/yy',
    dayNamesMin: [ "Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab" ],
    autoSize: true,
    changeMonth: true,
    changeYear: true,
    showButtonPanel: true,
    closeText: "Fechar"
  });
</script>