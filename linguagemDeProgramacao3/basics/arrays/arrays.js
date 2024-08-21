const exerciseOne = () => {
	const lista = []
	for (let i = 0; i <= 10; i++) lista.push(Math.floor(Math.random() * 100))

	console.log("lista: " + lista)
	console.log("lista length: " + lista.length)
}

const exerciseTwo = () => {
	const lista = []
	for (let i = 0; i <= 5; i++) lista.push(Math.floor(Math.random() * 100))

	console.log("lista before inserting new item: " + lista)
	lista.unshift(Math.floor(Math.random() * 100))
	console.log("lista after inserting new item: " + lista)
}

const exerciseThree = () => {
	const lista = []
	for (let i = 0; i <= 3; i++) lista.push(Math.floor(Math.random() * 100))

	console.log("lista changing anything: " + lista)
	lista[0] = lista[0] * 2
	console.log("lista after changing first item: " + lista)
}

const exerciseFour = () => {
	const lista = []

	console.log("lista empty: " + lista)
	for (let i = 0; i <= 3; i++) lista.push(Math.floor(Math.random() * 100))
	console.log("lista with items: " + lista)
}

const exerciseFive = () => {
	const lista = ["cachorro", "gato", "papagaio", "peixe", "hamster"]
	console.log("lista of animals in the petshop: " + lista)
	lista.forEach((item) => console.log(item + " foi atendido"))
	console.log("Atendimento finalizado. Todos os animais foram atendidos.")
}

console.log("Exercise 1\n")
exerciseOne()
console.log("\nExercise 2\n")
exerciseTwo()
console.log("\nExercise 3\n")
exerciseThree()
console.log("\nExercise 4\n")
exerciseFour()
console.log("\nExercise 5\n")
exerciseFive()