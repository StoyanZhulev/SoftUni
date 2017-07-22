function summarizeResults(arr) {
    let systemCandidates = new Map();
    let resultSystems = new Map();
    let systemWinners = [];
    for (let ballot of arr) {
        let sys = ballot.system;
        let cand = ballot.candidate;
        let votes = Number(ballot.votes);
        if(!systemCandidates.has(sys)){
            systemCandidates.set(sys, new Map());
        }
        if(!systemCandidates.get(sys).has(cand)){
            systemCandidates.get(sys).set(cand, 0);
        }

        systemCandidates.get(sys).set(cand, systemCandidates.get(sys).get(cand) + votes);
    }
    for (let sys of systemCandidates.keys()) {
        let winner = '';
        let winnerVotes = 0;
        let maxVotes = 0;
        for (let cand of systemCandidates.get(sys).keys()) {
            let candVotes = systemCandidates.get(sys).get(cand);
            if(candVotes > winnerVotes){
                winnerVotes = candVotes;
                winner = cand;
            }
            maxVotes += candVotes;
        }
        if(!resultSystems.has(winner)){
            resultSystems.set(winner, new Map());
        }
        if(!resultSystems.get(winner).has(sys)){
            resultSystems.get(winner).set(sys, 0);
        }

        resultSystems.get(winner).set(sys, resultSystems.get(winner).get(sys) + maxVotes);
    }
    let allVotes = 0;

    for (let winner of resultSystems.keys()) {
        let votes = 0;
        for (let sys of resultSystems.get(winner).keys()) {
            votes+= resultSystems.get(winner).get(sys);
        }

        let win = {name: winner, votes: votes}
        allVotes += votes;
        systemWinners.push(win);
    }

    systemWinners.sort((w1, w2) => w2.votes - w1.votes);
    if(systemWinners.length === 1){
        let result = `${systemWinners[0].name} wins with ${systemWinners[0].votes} votes\n`;
        result += `${systemWinners[0].name} wins unopposed!`;

        return result;
    }
    if(systemWinners[0].votes > allVotes / 2){
        let result = `${systemWinners[0].name} wins with ${systemWinners[0].votes} votes\n`;
                 result += `Runner up: ${systemWinners[1].name}\n`;
        for (let runnerUp of resultSystems.keys()) {
            if(runnerUp === systemWinners[1].name){

                [...resultSystems.get(runnerUp).keys()].sort((v1, v2) =>
                resultSystems.get(runnerUp).get(v2) - resultSystems.get(runnerUp).get(v1))
                    .forEach(e => result += (`${e}: ${resultSystems.get(runnerUp).get(e)}\n`));
            }
        }

        return result;
    }else{
        return `Runoff between ${systemWinners[0].name} with ${Math.floor(systemWinners[0].votes / allVotes * 100)}% and ${systemWinners[1].name} with ${Math.floor(systemWinners[1].votes / allVotes * 100)}%`
    }
}


console.log(summarizeResults([ { system: 'Theta', candidate: 'Kim Jong Andromeda', votes: 10 },
    { system: 'Tau',   candidate: 'Kim Jong Andromeda', votes: 200 },
    { system: 'Tau',   candidate: 'Flying Shrimp',      votes: 150 } ]


));