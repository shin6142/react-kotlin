package com.example.api.domain.user

import java.util.UUID

class Member(private val id: UUID, private val name: String) {
    fun updateName(newName: String): Member {
        return Member(id, newName)
    }
}

class Team(
    private val id: UUID,
    private val name: String,
    private val members: List<Member>
)
{
    fun addMember(member: Member): Team {
        return Team(id, name, members + member)
    }
}

class MemberRepository {
    private val members = mutableListOf<Member>()
    fun save(member: Member) {
        members.add(member)
    }
}

class TeamRepository {
    private val teams = mutableListOf<Team>()
    fun save(team: Team) {
        // save team
        teams.add(team)
    }
}
