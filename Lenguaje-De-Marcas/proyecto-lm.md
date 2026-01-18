//dtd

<!ELEMENT parking (origen, elaborado, tarifas, plazas, abonados, accesos)>

<!ELEMENT origen (nombre, web, language, nota_legal)>
<!ELEMENT nombre (#PCDATA)>
<!ELEMENT web (#PCDATA)>
<!ELEMENT language (#PCDATA)>
<!ELEMENT nota_legal (#PCDATA)>

<!ELEMENT elaborado (#PCDATA)>

<!ELEMENT tarifas (tarifa+)>
<!ATTLIST tarifas moneda CDATA #REQUIRED>

<!ELEMENT tarifa (descripcion, (precio_hora, max_diario | precio_mensual, acceso_24h))>
<!ATTLIST tarifa
  id   CDATA #REQUIRED
  tipo CDATA #REQUIRED
>
<!ELEMENT descripcion (#PCDATA)>
<!ELEMENT precio_hora (#PCDATA)>
<!ELEMENT max_diario (#PCDATA)>
<!ELEMENT precio_mensual (#PCDATA)>
<!ELEMENT acceso_24h (#PCDATA)>

<!ELEMENT plazas (plaza+)>
<!ATTLIST plazas total CDATA #REQUIRED>

<!ELEMENT plaza (matricula?, entrada?, observacion?, carga_kw?)>
<!ATTLIST plaza
  id     CDATA #REQUIRED
  planta CDATA #REQUIRED
  tipo   CDATA #REQUIRED
  estado CDATA #REQUIRED
>
<!ELEMENT matricula (#PCDATA)>
<!ELEMENT entrada (#PCDATA)>
<!ELEMENT observacion (#PCDATA)>
<!ELEMENT carga_kw (#PCDATA)>

<!ELEMENT abonados (abonado+)>
<!ELEMENT abonado (nombre, matricula, vigencia_desde, vigencia_hasta, tarifa_ref)>
<!ATTLIST abonado
  id   CDATA #REQUIRED
  tipo CDATA #REQUIRED
>
<!ELEMENT vigencia_desde (#PCDATA)>
<!ELEMENT vigencia_hasta (#PCDATA)>
<!ELEMENT tarifa_ref (#PCDATA)>

<!ELEMENT accesos (registro+)>
<!ELEMENT registro (fecha_hora, matricula, plaza_ref?)>
<!ATTLIST registro
  id     CDATA #REQUIRED
  evento CDATA #REQUIRED
>
<!ELEMENT fecha_hora (#PCDATA)>
<!ELEMENT plaza_ref (#PCDATA)>

//validaciones/parking_xsd-xml

<?xml version="1.0" encoding="UTF-8"?>
<parking xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:noNamespaceSchemaLocation="parking.xsd">
  <!-- pega aquí TODO tu contenido EXACTO (igual que el original) -->
</parking


//validaciones/parking.xsd

<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xs:element name="parking">
    <xs:complexType>
      <xs:sequence>
        <xs:element name="origen" type="OrigenType"/>
        <xs:element name="elaborado" type="xs:dateTime"/>
        <xs:element name="tarifas" type="TarifasType"/>
        <xs:element name="plazas" type="PlazasType"/>
        <xs:element name="abonados" type="AbonadosType"/>
        <xs:element name="accesos" type="AccesosType"/>
      </xs:sequence>
    </xs:complexType>
  </xs:element>

  <xs:complexType name="OrigenType">
    <xs:sequence>
      <xs:element name="nombre" type="xs:string"/>
      <xs:element name="web" type="xs:string"/>
      <xs:element name="language" type="xs:string"/>
      <xs:element name="nota_legal" type="xs:string"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="TarifasType">
    <xs:sequence>
      <xs:element name="tarifa" type="TarifaType" maxOccurs="unbounded"/>
    </xs:sequence>
    <xs:attribute name="moneda" type="xs:string" use="required"/>
  </xs:complexType>

  <xs:complexType name="TarifaType">
    <xs:sequence>
      <xs:element name="descripcion" type="xs:string"/>
      <xs:choice>
        <xs:sequence>
          <xs:element name="precio_hora" type="xs:decimal"/>
          <xs:element name="max_diario" type="xs:decimal"/>
        </xs:sequence>
        <xs:sequence>
          <xs:element name="precio_mensual" type="xs:decimal"/>
          <xs:element name="acceso_24h" type="xs:boolean"/>
        </xs:sequence>
      </xs:choice>
    </xs:sequence>
    <xs:attribute name="id" type="xs:string" use="required"/>
    <xs:attribute name="tipo" type="xs:string" use="required"/>
  </xs:complexType>

  <xs:complexType name="PlazasType">
    <xs:sequence>
      <xs:element name="plaza" type="PlazaType" maxOccurs="unbounded"/>
    </xs:sequence>
    <xs:attribute name="total" type="xs:integer" use="required"/>
  </xs:complexType>

  <xs:complexType name="PlazaType">
    <xs:sequence>
      <xs:element name="matricula" type="xs:string" minOccurs="0"/>
      <xs:element name="entrada" type="xs:dateTime" minOccurs="0"/>
      <xs:element name="observacion" type="xs:string" minOccurs="0"/>
      <xs:element name="carga_kw" type="xs:integer" minOccurs="0"/>
    </xs:sequence>
    <xs:attribute name="id" type="xs:string" use="required"/>
    <xs:attribute name="planta" type="xs:integer" use="required"/>
    <xs:attribute name="tipo" type="xs:string" use="required"/>
    <xs:attribute name="estado" type="xs:string" use="required"/>
  </xs:complexType>

  <xs:complexType name="AbonadosType">
    <xs:sequence>
      <xs:element name="abonado" type="AbonadoType" maxOccurs="unbounded"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="AbonadoType">
    <xs:sequence>
      <xs:element name="nombre" type="xs:string"/>
      <xs:element name="matricula" type="xs:string"/>
      <xs:element name="vigencia_desde" type="xs:date"/>
      <xs:element name="vigencia_hasta" type="xs:date"/>
      <xs:element name="tarifa_ref" type="xs:string"/>
    </xs:sequence>
    <xs:attribute name="id" type="xs:string" use="required"/>
    <xs:attribute name="tipo" type="xs:string" use="required"/>
  </xs:complexType>

  <xs:complexType name="AccesosType">
    <xs:sequence>
      <xs:element name="registro" type="RegistroType" maxOccurs="unbounded"/>
    </xs:sequence>
  </xs:complexType>

  <xs:complexType name="RegistroType">
    <xs:sequence>
      <xs:element name="fecha_hora" type="xs:dateTime"/>
      <xs:element name="matricula" type="xs:string"/>
      <xs:element name="plaza_ref" type="xs:string" minOccurs="0"/>
    </xs:sequence>
    <xs:attribute name="id" type="xs:string" use="required"/>
    <xs:attribute name="evento" type="xs:string" use="required"/>
  </xs:complexType>

</xs:schema>


parking_viewx.xml

<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="parking.xsl"?>
<parking>
  <!-- pega aquí TODO tu contenido EXACTO (igual que el original) -->
</parking>


parking.xsl

<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <xsl:template match="/">
    <html lang="es">
      <head>
        <meta charset="UTF-8"/>
        <title>Parking GUEMI - Visualización (XSLT)</title>
      </head>
      <body>
        <h1>Parking GUEMI - Datos del XML</h1>

        <h2>Tarifas</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Descripción</th>
            <th>Precio/hora</th>
            <th>Máx diario</th>
            <th>Precio mensual</th>
            <th>Acceso 24h</th>
          </tr>
          <xsl:for-each select="parking/tarifas/tarifa">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="@tipo"/></td>
              <td><xsl:value-of select="descripcion"/></td>
              <td><xsl:value-of select="precio_hora"/></td>
              <td><xsl:value-of select="max_diario"/></td>
              <td><xsl:value-of select="precio_mensual"/></td>
              <td><xsl:value-of select="acceso_24h"/></td>
            </tr>
          </xsl:for-each>
        </table>

        <h2>Plazas</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Planta</th>
            <th>Tipo</th>
            <th>Estado</th>
            <th>Matrícula</th>
            <th>Entrada</th>
            <th>Observación</th>
            <th>Carga (kW)</th>
          </tr>
          <xsl:for-each select="parking/plazas/plaza">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="@planta"/></td>
              <td><xsl:value-of select="@tipo"/></td>
              <td><xsl:value-of select="@estado"/></td>
              <td><xsl:value-of select="matricula"/></td>
              <td><xsl:value-of select="entrada"/></td>
              <td><xsl:value-of select="observacion"/></td>
              <td><xsl:value-of select="carga_kw"/></td>
            </tr>
          </xsl:for-each>
        </table>

        <h2>Abonados</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Tipo</th>
            <th>Nombre</th>
            <th>Matrícula</th>
            <th>Desde</th>
            <th>Hasta</th>
            <th>Tarifa ref</th>
          </tr>
          <xsl:for-each select="parking/abonados/abonado">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="@tipo"/></td>
              <td><xsl:value-of select="nombre"/></td>
              <td><xsl:value-of select="matricula"/></td>
              <td><xsl:value-of select="vigencia_desde"/></td>
              <td><xsl:value-of select="vigencia_hasta"/></td>
              <td><xsl:value-of select="tarifa_ref"/></td>
            </tr>
          </xsl:for-each>
        </table>

        <h2>Accesos (entradas y salidas)</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Evento</th>
            <th>Fecha/Hora</th>
            <th>Matrícula</th>
            <th>Plaza ref</th>
          </tr>
          <xsl:for-each select="parking/accesos/registro">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="@evento"/></td>
              <td><xsl:value-of select="fecha_hora"/></td>
              <td><xsl:value-of select="matricula"/></td>
              <td><xsl:value-of select="plaza_ref"/></td>
            </tr>
          </xsl:for-each>
        </table>

      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>

index.html 

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Parking GUEMI - Inicio</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>

    <figure>
      <img src="img/logo.png" alt="Logo Parking GUEMI" width="140">
      <figcaption>Aplicación informativa del parking</figcaption>
    </figure>

    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="contacto.html">Contacto</a></li>
        <li><a href="visualizacion.html">Visualización</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section>
      <h2>Accesos rápidos</h2>
      <ul>
        <li><a href="parking_view.xml">Abrir XML con XSLT (recomendado)</a></li>
        <li><a href="Validaciones/parking.xml">Ver XML original</a></li>
        <li><a href="https://www.parking-guemi.es" target="_blank" rel="noopener">Web externa</a></li>
      </ul>
    </section>

    <section>
      <h2>Resumen</h2>
      <article>
        <p>La visualización obligatoria se hace mediante XSLT (archivo <strong>parking.xsl</strong>).</p>
      </article>
    </section>
  </main>

  <footer>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
  </footer>
</body>
</html>

visualizacion.html


<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Parking GUEMI - Visualización</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="contacto.html">Contacto</a></li>
        <li><a href="visualizacion.html">Visualización</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section>
      <h2>XML dentro del HTML (iframe)</h2>
      <p>Mostrando el XML enlazado con XSLT:</p>

      <iframe src="parking_view.xml" width="100%" height="550px"></iframe>
    </section>
  </main>

  <footer>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
  </footer>
</body>
</html>


//contacto.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Parking GUEMI - Contacto</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <img src="img/logo.png" alt="Logo Parking GUEMI" width="140">
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section>
      <h2>Contacto</h2>
      <form action="#" method="GET">
        <fieldset>
          <legend>Envíanos tu consulta</legend>

          <p>
            <label for="nombre">Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" placeholder="Tu nombre">
          </p>

          <p>
            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" placeholder="tu@email.com">
          </p>

          <p>
            <label for="tipo">Tipo de consulta:</label><br>
            <select id="tipo" name="tipo">
              <option value="tarifas">Tarifas</option>
              <option value="abonados">Abonos</option>
              <option value="plazas">Plazas</option>
              <option value="otros">Otros</option>
            </select>
          </p>

          <p>
            <label for="mensaje">Mensaje:</label><br>
            <textarea id="mensaje" name="mensaje" rows="5" cols="30" placeholder="Escribe aquí..."></textarea>
          </p>

          <p>
            <button type="submit">Enviar</button>
          </p>
        </fieldset>
      </form>

      <article>
        <h3>Enlace externo</h3>
        <p>Política legal: <a href="https://www.parking-guemi.es/legal" target="_blank" rel="noopener">ver</a></p>
      </article>
    </section>
  </main>

  <footer>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
  </footer>
</body>
</html>


//accesos.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Parking GUEMI - Accesos</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <img src="img/logo.png" alt="Logo Parking GUEMI" width="140">
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section>
      <h2>Registro de accesos</h2>
      <p>Tabla completa en <a href="parking_view.xml">XML + XSLT</a>.</p>

      <article>
        <h3>Eventos posibles (lista ordenada)</h3>
        <ol>
          <li>entrada</li>
          <li>salida</li>
        </ol>
      </article>

      <article>
        <h3>Muestra de registros</h3>
        <table style="border:1px solid black;" cellpadding="5" cellspacing="2" width="100%">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Evento</th>
            <th scope="col">Fecha/Hora</th>
            <th scope="col">Matrícula</th>
            <th scope="col">Plaza</th>
          </tr>
          <tr><td>R-001</td><td>entrada</td><td>2025-12-01T07:45:00</td><td>1234KLM</td><td>PZ-001</td></tr>
          <tr><td>R-003</td><td>salida</td><td>2025-12-01T08:25:00</td><td>9999ZZZ</td><td>(sin plaza)</td></tr>
        </table>
      </article>
    </section>
  </main>

  <footer>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
  </footer>
</body>
</html>

//abonados.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Parking GUEMI - Abonados</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <img src="img/logo.png" alt="Logo Parking GUEMI" width="140">
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section>
      <h2>Abonados</h2>
      <p>Consulta completa en <a href="parking_view.xml">XML + XSLT</a>.</p>

      <table style="border:1px solid black;" cellpadding="5" cellspacing="2" width="100%">
        <tr>
          <th scope="col">ID</th>
          <th scope="col">Tipo</th>
          <th scope="col">Nombre</th>
          <th scope="col">Tarifa</th>
        </tr>
        <tr><td>A-001</td><td>mensual</td><td>María López</td><td>T-002</td></tr>
        <tr><td>A-002</td><td>nocturno</td><td>Carlos Pérez</td><td>T-003</td></tr>
        <tr><td>A-003</td><td>mensual</td><td>Lucía Sánchez</td><td>T-002</td></tr>
      </table>
    </section>
  </main>

  <footer>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
  </footer>
</body>
</html>


//plazas.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Parking GUEMI - Plazas</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <img src="img/logo.png" alt="Logo Parking GUEMI" width="140">
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section>
      <h2>Estado de plazas</h2>
      <p>Listado detallado en <a href="parking_view.xml">XML + XSLT</a>.</p>

      <article>
        <h3>Tipos de plaza (lista)</h3>
        <ul>
          <li>Coche</li>
          <li>Moto</li>
          <li>PMR</li>
          <li>Eléctrico</li>
        </ul>
      </article>

      <article>
        <h3>Ejemplo de tabla (muestra)</h3>
        <table style="border:1px solid black;" cellpadding="5" cellspacing="2" width="100%">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Planta</th>
            <th scope="col">Tipo</th>
            <th scope="col">Estado</th>
          </tr>
          <tr><td>PZ-001</td><td>-1</td><td>coche</td><td>ocupada</td></tr>
          <tr><td>PZ-002</td><td>-1</td><td>coche</td><td>libre</td></tr>
          <tr><td>PZ-006</td><td>1</td><td>electrico</td><td>ocupada</td></tr>
        </table>
      </article>
    </section>
  </main>

  <footer>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
  </footer>
</body>
</html>

//tarifas.html

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Parking GUEMI - Tarifas</title>
</head>
<body>
  <header>
    <h1>Parking GUEMI</h1>
    <img src="img/logo.png" alt="Logo Parking GUEMI" width="140">
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="tarifas.html">Tarifas</a></li>
        <li><a href="plazas.html">Plazas</a></li>
        <li><a href="abonados.html">Abonados</a></li>
        <li><a href="accesos.html">Accesos</a></li>
        <li><a href="contacto.html">Contacto</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section>
      <h2>Tarifas del parking</h2>
      <p>Consulta la tabla completa en <a href="parking_view.xml">XML + XSLT</a>.</p>

      <table style="border:1px solid black;" cellpadding="5" cellspacing="2" width="100%">
        <tr>
          <th scope="col">Tipo</th>
          <th scope="col">Descripción</th>
          <th scope="col">Detalles</th>
        </tr>
        <tr>
          <td>Rotación</td>
          <td>Rotación por horas</td>
          <td>2,20 €/hora · Máx diario 18 €</td>
        </tr>
        <tr>
          <td>Abono</td>
          <td>Abono mensual</td>
          <td>95 €/mes · Acceso 24h</td>
        </tr>
        <tr>
          <td>Abono</td>
          <td>Abono nocturno</td>
          <td>55 €/mes · Sin acceso 24h</td>
        </tr>
      </table>

      <article>
        <h3>Notas</h3>
        <ul>
          <li>Los precios son orientativos (ver XML oficial).</li>
          <li>Para abonados, se recomienda revisar vigencias.</li>
        </ul>
      </article>
    </section>
  </main>

  <footer>
    <p>&copy; 2026 Parking GUEMI · Proyecto LLMM</p>
  </footer>
</body>
</html>



