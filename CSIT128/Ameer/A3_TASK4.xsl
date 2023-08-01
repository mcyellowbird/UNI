<!--  Assignment 3 (Task 4 XSLT) by INSERT FULL NAME (INSERT STUDENT NUMBER)  -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
	<html lang="en">
		<head>
			<meta charset="utf-8"/>
			<title>DPIT128: Assignment 3 (Task 4 XSLT)</title>
			<style> /* BEGIN: Template CSS (DO NOT ALTER/REMOVE) ----------- */ body { background-color:#ededed; text-align:center; } table { margin-left:auto; margin-right:auto; } /* END: Template CSS (DO NOT ALTER/REMOVE) ------------- */ /* INSERT INTERNAL CSS HERE */ 
				table {
					border: 1px solid #808080;
					border-collapse: collapse;
				}

				th {
					background-color: #b9b9b9;
					padding: 10px;
					font-size: 20px;
					border: 1px solid #808080;
				}

				td {
					padding: 10px;
					font-size: 20px;
					border: 1px solid #808080;
				}

				tr:nth-child(even) {
					background-color: #e0e0e0;
				}

				.numbers {
					text-align: center;
				}

				.red {
					background-color: #ff9999;
				}

				.yellow {
					background-color: #ffdb99;
				}

				.green {
					background-color: #99cc99;
				}
			</style>
		</head>
		<body>
			<h1>DPIT128: Assignment 3</h1>
			<h2>INSERT FULL NAME (INSERT STUDENT NUMBER)</h2>
			<h3>Date Due: 12/08/2022</h3>
			<hr/>
			<p style="font-weight:bold;">
				I have viewed the College's policy regarding Academic Integrity as provided at the following URL:

				<br/>
				<a href="https://documents.uow.edu.au/content/groups/public/@web/@uowc/documents/doc/uow218734.pdf" target="_blank"> https://documents.uow.edu.au/content/groups/public/@web/@uowc/documents/doc/uow218734.pdf </a>
			</p>
			<hr/>
			<h2>Task 4 XSLT</h2>
			<!--  BEGIN: Task 4 Solution  -->
			<h2>Hotel Comparison Table</h2>
			<table>
				<caption style="font-size: 20px; padding-bottom:10px;">Search Location: <xsl:value-of select="comparisons/@location"/></caption>
				<tr>
					<th>Hotel Name</th>
					<th>Star Rating</th>
					<th>Total Reviews</th>
					<th>Overall Score</th>
				</tr>
				<xsl:for-each select="comparisons/hotel">
				<tr>
					<td><xsl:value-of select="name"/></td>
					<td class="numbers"><xsl:value-of select="stars"/></td>
					<td class="numbers"><xsl:value-of select="format-number(reviews, '#,###')"/></td>
					<xsl:choose>
						<xsl:when test="score &lt; 8.5">
							<td class="numbers red"><xsl:value-of select="score"/></td>
						</xsl:when>
						<xsl:when test="score &gt;= 8.5 and score &lt; 9.0">
							<td class="numbers yellow"><xsl:value-of select="score"/></td>
						</xsl:when>
						<xsl:otherwise>
							<td class="numbers green"><xsl:value-of select="score"/></td>
						</xsl:otherwise>
					</xsl:choose>
				</tr>
				</xsl:for-each>
			</table>

			<h3><b>This information was obtained from <a href="https://www.trivago.com.au/" target="_blank">Trivago</a> on <a id="date"></a></b></h3>
			<script>
				let date = new Date().toLocaleDateString('en-GB', {month: '2-digit', day: '2-digit', year: 'numeric'});
				document.getElementById("date").innerHTML = date;
			</script>

			<!--  END: Task 4 Solution  -->
			<p>© INSERT FULL NAME</p>
		</body>
	</html>
</xsl:template>

</xsl:stylesheet>